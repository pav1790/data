package controllers;

import dataconnectors.EventDataConnector;
import dataconnectors.OrganizerDataConnector;
import dataconnectors.ParticipantDataConnector;
import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

import java.util.List;

import static play.libs.Scala.asScala;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EventController extends Controller {

    private final Form<EventData> eventDataForm;
    private final Form<ParticipantEventData> participantEventDataForm;

    private static EventDataConnector eventDataConnector = EventDataConnector.INSTANCE;
    private static OrganizerDataConnector organizerDataConnector = OrganizerDataConnector.INSTANCE;
    private static ParticipantDataConnector participantDataConnector = ParticipantDataConnector.INSTANCE;


    @Inject
    public EventController(FormFactory formFactory) {
        this.eventDataForm = formFactory.form(EventData.class);
        this.participantEventDataForm = formFactory.form(ParticipantEventData.class);
        Address sampleAddress = new Address("Street 1", "Street2", "City", "OH", 43065, "US");
        String organizerId = organizerDataConnector.getAllOrganizers().keySet().iterator().next();
        Event event = new Event("Sample Event", sampleAddress, organizerId, 10, "5k", 20.0);
        eventDataConnector.creatEvent(event);
    }

    public Result viewAllEvents() {
        return ok(views.html.listEvents.render(asScala(eventDataConnector.getAllEvents().values()), eventDataForm));
    }

    public Result createEvent() {
        final Form<EventData> boundForm = eventDataForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            play.Logger.ALogger logger = play.Logger.of(getClass());
            logger.error("errors = {}", boundForm.errors());
            return badRequest(views.html.listEvents.render(asScala(eventDataConnector.getAllEvents().values()), boundForm));
        } else {
            EventData data = boundForm.get();
            Address address = new Address(data.getStreet1(), data.getStreet2(), data.getCity(), data.getState(), data.getZip(), data.getCountry());
            Event event = new Event(data.getTitle(), address, data.getOrganizerId(), data.getParticipantCap(), data.getEventType(), data.getEventCost());
            eventDataConnector.creatEvent(event);
            flash("info", "Event created!");
            return redirect(routes.EventController.viewAllEvents());
        }
    }

    public Result viewEvent(String id) {
        Event event = eventDataConnector.getEvent(id);
        List<String> participantIds = event.getParticipantIdList();
        List<Person> participants = participantDataConnector.getParticipants(participantIds);
        return ok(views.html.listEventDetails.render(event, asScala(participants), participantEventDataForm));
    }

    public Result editEventData(String id) {
        return ok(views.html.index.render());
    }

    public Result viewAllRegisteredParticipants(String id) {
        return ok(views.html.index.render());
    }

    public Result addParticipant(String id) {
        return ok(views.html.index.render());
    }

    public Result viewRegisteredParticipant(String id) {
        return ok(views.html.index.render());
    }

}
