package controllers;

import dataconnectors.OrganizerDataConnector;
import models.Address;
import models.Organizer;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

import static play.libs.Scala.asScala;

public class OrganizerController extends Controller {

    private final Form<OrganizerData> form;
    private static OrganizerDataConnector organizerDataConnector = OrganizerDataConnector.INSTANCE;

    @Inject
    public OrganizerController(FormFactory formFactory) {
        this.form = formFactory.form(OrganizerData.class);
        if (organizerDataConnector.getAllOrganizers().isEmpty()) {
            Address sampleAddress = new Address("Street 1", "Street2", "City", "OH", 43065, "US");
            Organizer organizer = new Organizer("Sample", "Organizer", "sampleorganizer@email.com", "5555555555", sampleAddress);
            organizerDataConnector.registerOrganizer(organizer);
        }
    }

    public Result viewAllOrganizers() {
        return ok(views.html.listOrganizers.render(asScala(organizerDataConnector.getAllOrganizers().values()), form));
    }

    public Result createOrganizer() {
        final Form<OrganizerData> boundForm = form.bindFromRequest();

        if (boundForm.hasErrors()) {
            play.Logger.ALogger logger = play.Logger.of(getClass());
            logger.error("errors = {}", boundForm.errors());
            return badRequest(views.html.listOrganizers.render(asScala(organizerDataConnector.getAllOrganizers().values()), boundForm));
        } else {
            OrganizerData data = boundForm.get();
            Address address = new Address(data.getStreet1(), data.getStreet2(), data.getCity(), data.getState(), data.getZip(), data.getCountry());
            Organizer organizer = new Organizer(data.getFirstName(), data.getLastName(), data.getEmail(), data.getMobileNumber(), address);
            organizerDataConnector.registerOrganizer(organizer);
            flash("info", "Organizer added!");
            return redirect(routes.OrganizerController.viewAllOrganizers());
        }
    }

}
