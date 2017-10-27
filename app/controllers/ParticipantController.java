package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ParticipantController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        // TODO - show list of participants
        // TODO - make link to register participant form
        return ok();
    }

    public Result register() {
        // TODO - add new participant
        return ok();
    }

    public Result getParticipant(String id) {
        // TODO - retrieve data on participant
        return ok(views.html.index.render());
    }

    public Result editParticipant(String id) {
        // TODO - edit participant based on id
        return ok();
    }
}
