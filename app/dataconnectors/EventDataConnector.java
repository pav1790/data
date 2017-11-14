package dataconnectors;

import models.*;

import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum EventDataConnector {
    INSTANCE;

    private static ParticipantDataConnector participantDataConnector = ParticipantDataConnector.INSTANCE;

    private Map<String, Event> catalog = new HashMap<>();

    public boolean creatEvent(Event event) {
        catalog.put(event.getId(), event);
        return true;
    }

    public Map<String, Event> getAllEvents() {
        if (catalog.isEmpty()) {
            Organizer sampleOrganizer = OrganizerDataConnector.INSTANCE.getAllOrganizers().entrySet().iterator().next().getValue();
            Address sampleAddress = new Address("Street 1", "Street2", "City", "OH", 43065, "US");
            Event sampleEvent = new Event("Sample Event", sampleOrganizer.getId(), new Date(Year.now().getValue(), 12, 31), sampleAddress, new EventOption( 10, "5k", 10.0));
            creatEvent(sampleEvent);
        }

        return catalog;
    }

    public Event getEvent(Event event) {
        return catalog.get(event.getId());
    }

    public Event getEvent(String id) {
        return catalog.get(id);
    }

    public boolean registerParticipant(String eventReferralId, Person participant) {
        participantDataConnector.registerParticipant(participant);
        return catalog.get(eventReferralId).registerParticipant(participant);
    }
}
