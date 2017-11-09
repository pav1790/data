package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dataconnectors.EventDataConnector;
import dataconnectors.OrganizerDataConnector;
import dataconnectors.ParticipantDataConnector;
import models.*;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EventController extends Controller {

    private static EventDataConnector eventDataConnector = EventDataConnector.INSTANCE;
    private static OrganizerDataConnector organizerDataConnector = OrganizerDataConnector.INSTANCE;
    private static ParticipantDataConnector participantDataConnector = ParticipantDataConnector.INSTANCE;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        // TODO - show list of events
        // TODO - make links to create event form
        JsonNode stuff = Json.toJson(eventDataConnector.getAllEvents());
        return ok(views.html.eventindex.render());
    }

    public Result createEvent() {
        // TODO - user response to get info on event being created
        String title = request().getQueryString("title");

        Address address = createAddress(request());

        Organizer organizer = organizerDataConnector.getOrganizer(request().getQueryString("organizer"));

        int participantCap = Integer.parseInt(request().getQueryString("cap"));

        Map<String, Double> eventOptions = new HashMap<String, Double>();
        /** TODO - create options for each one found
        *      example: {[5k, $40], [10k, $60]}
        * */

        Event event = new Event(title, address, organizer, participantCap, eventOptions);
        eventDataConnector.creatEevent(event);
        return ok();
    }

    public Result getEventData(String id) {
        // TODO - return info on 1 event
        Event event = eventDataConnector.getEvent(id);
        return ok(views.html.index.render());
    }

    public Result editEventData(String id) {
        // TODO - edit the event with the given ID
        return ok();
    }

    public Result getParticipantList(String id) {
        // TODO - return the participant list for the given event
        List<String> participantIdList = eventDataConnector.getEvent(id).getParticipantIdList();
        List<Person> participantList = participantDataConnector.getParticipantList(participantIdList);
        return ok();
    }

    public Result addParticipant(String id) {
        // Person info
        String eventReferral = request().getQueryString("eventReferral");
        String email = request().getQueryString("email");
        Person participant = participantDataConnector.getParticipantViaEmail(email);
        if (participant == null) {

            String firstName = request().getQueryString("firstname");
            String lastName = request().getQueryString("lastname");
            DateOfBirth dateOfBirth = new DateOfBirth(request().getQueryString("day"), request().getQueryString("month"), request().getQueryString("year"));
            Address address = createAddress(request());
            String mobileNumber = request().getQueryString("mobileNumber");
            String gender = request().getQueryString("gender");
            String shirtSize = request().getQueryString("shirtSize");
            String estFinishTime = request().getQueryString("estFinishTime");
            String wheelChair = request().getQueryString("wheelChair");
            String emergencyContact = request().getQueryString("emergencyContact");
            String emergencyContactNumber = request().getQueryString("emergencyContactNumber");
            String medicalConditions = request().getQueryString("medicalConditions");


            participant = new Person(firstName, lastName, dateOfBirth, email,
                    mobileNumber, gender, address, shirtSize, estFinishTime, Boolean.getBoolean(wheelChair),
                    emergencyContact, emergencyContactNumber, medicalConditions, eventReferral);
        } else {
            // TODO - update info if does not exist or changed
        }
        eventDataConnector.registerParticipant(eventReferral, participant);
        return ok();
    }

    public Result getParticipant(String id) {
        return ok();
    }

    private Address createAddress(Request request) {
        String street1 = request().getQueryString("street1");
        String street2 = request().getQueryString("street2");
        String city = request().getQueryString("city");
        String state = request().getQueryString("state");
        int zip = Integer.parseInt(request().getQueryString("zip"));
        String country = request().getQueryString("country");
        return new Address(street1, street2, city, state, zip, country);
    }

    public Result viewAllParticipants() {
        // TODO
        participantDataConnector.getAllParticipants();
        return ok();
    }

}
