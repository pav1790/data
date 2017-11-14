package controllers;

import dataconnectors.EventDataConnector;
import dataconnectors.OrganizerDataConnector;
import dataconnectors.ParticipantDataConnector;
import helpers.IDMaker;
import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;

import java.time.Year;
import java.util.*;

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

        // Create sample event
        Address sampleAddress = new Address("Street 1", "Street2", "City", "OH", 43065, "US");
        String organizerId = organizerDataConnector.getAllOrganizers().keySet().iterator().next();
        EventOption eventOption = new EventOption(10, "5k", 20.0);
        Event event = new Event("Sample Event", organizerId, new Date(Year.now().getValue(), 12, 31), sampleAddress,  eventOption);
        eventDataConnector.creatEvent(event);
        System.out.println("Event sub ID: " + event.getEventOptions().keySet().iterator().next());
        // Populate sample event with someone
        Person person = new Person("Joe", "Cooler", new Date(1980,1,1), "joecooler@email.com",
                "5551236541", "Male", sampleAddress, "Small", event.getEventOptions().keySet().iterator().next(), "2:30:45", false,
                "E C", "5553216541",  "none", event.getId());
        eventDataConnector.registerParticipant(event.getId(),person);
    }

    public Result viewAllEvents() {
        return ok(views.html.listEvents.render(asScala(eventDataConnector.getAllEvents().values()), organizerDataConnector.getAllOrganizers(), eventDataForm));
    }

    public Result createEvent() {
        final Form<EventData> boundForm = eventDataForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            play.Logger.ALogger logger = play.Logger.of(getClass());
            logger.error("errors = {}", boundForm.errors());
            return badRequest(views.html.listEvents.render(asScala(eventDataConnector.getAllEvents().values()), organizerDataConnector.getAllOrganizers(), boundForm));
        } else {
            EventData data = boundForm.get();
            Address address = new Address(data.getStreet1(), data.getStreet2(), data.getCity(), data.getState(), data.getZip(), data.getCountry());
            Map<String, EventOption> eventOptionMap = gatherEventOptionsInData(data);
            Event event = new Event(data.getTitle(), data.getOrganizerId(), data.getDate(), address);
            eventDataConnector.creatEvent(event);
            flash("info", "Event created!");
            return redirect(routes.EventController.viewAllEvents());
        }
    }

    private Map<String, EventOption> gatherEventOptionsInData(EventData data) {
        Map<String, EventOption> options = new HashMap<>();
        // Event Options
        EventOption option1 = new EventOption(data.getParticipantCap1(), data.getEventType1(), data.getEventCost1());
        options.put(IDMaker.INSTANCE.getNewID(), option1);
        if (data.getParticipantCap2() > 0 && !data.getEventType2().isEmpty() && data.getEventCost2() > 0) {
            EventOption option2 = new EventOption(data.getParticipantCap2(), data.getEventType2(), data.getEventCost2());
            options.put(IDMaker.INSTANCE.getNewID(), option2);
            if (data.getParticipantCap3() > 0 && !data.getEventType3().isEmpty() && data.getEventCost3() > 0) {
                EventOption option3 = new EventOption(data.getParticipantCap3(), data.getEventType3(), data.getEventCost3());
                options.put(IDMaker.INSTANCE.getNewID(), option3);
            }
        }

        return options;
    }

    public Result viewEvent(String id) {
        Event event = eventDataConnector.getEvent(id);
        List<String> participantIds = event.getParticipantIdList();
        List<Person> participants = participantDataConnector.getParticipants(participantIds);
        return ok(views.html.listEventDetails.render(event, asScala(participants), participantEventDataForm));
    }

    public Result editEventData(String id) {
        return redirect(routes.EventController.viewEvent(id));
    }

    public Result addParticipant(String id) {
        final Form<ParticipantEventData> boundForm = participantEventDataForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            play.Logger.ALogger logger = play.Logger.of(getClass());
            logger.error("errors = {}", boundForm.errors());
            Event event = eventDataConnector.getEvent(id);
            List<String> participantIds = event.getParticipantIdList();
            List<Person> participants = participantDataConnector.getParticipants(participantIds);
            return badRequest(views.html.listEventDetails.render(event, asScala(participants), boundForm));
        } else {
            ParticipantEventData data = boundForm.get();
            Address address = new Address(data.getStreet1(), data.getStreet2(), data.getCity(), data.getState(), data.getZip(), data.getCountry());
            Person person = new Person(data.getFirstName(), data.getLastName(), data.getDateOfBirth(), data.getEmail(), data.getMobileNumber(), data.getGender(),
                    address, data.getShirtSize(), data.getEventOption(), data.getEstFinishTime(), data.isWheelChair(), data.getEmergencyContact(), data.getEmergencyContactNumber(),
                    data.getMedicalConditions(), data.getEventReferralId());
            eventDataConnector.registerParticipant(data.getEventReferralId(), person);
            flash("info", "Event created!");
            return redirect(routes.EventController.viewEvent(id));
        }
    }

}
