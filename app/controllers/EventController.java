package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Event;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EventController extends Controller {

    private Map<String, Event> eventList;


    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        // TODO - show list of events
        // TODO - make links to create event form
        return ok(Json.toJson(eventList));
    }

    public Result createEvent() {
        // TODO - user response to get info on event being created
        return ok();
    }

    public Result getEventData(String id) {
        // TODO - return info on 1 event
        return ok(views.html.index.render());
    }

    public Result editEventData(String id) {
        // TODO - edit the event with the given ID
        return ok();
    }

    public Result getParticipantList(String id) {
        // TODO - return the participant list for the given event
        return ok();
    }

    public Result addParticipant(String id) {
        // TODO - return the participant list for the given event
        return ok();
    }

}
