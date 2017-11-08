package dataconnectors;

import models.Event;
import models.Participant;

import java.util.HashMap;
import java.util.Map;

public enum EventDataConnector {
    INSTANCE;

    private static ParticipantDataConnector participantDataConnector = ParticipantDataConnector.INSTANCE;

    private Map<String, Event> catalog;

    public boolean creatEevent(Event event) {
        if (catalog == null) {
            catalog = new HashMap<>();
        }
        catalog.put(event.getId(), event);
        return true;
    }

        public Map<String, Event> getAllEvents() {
            return catalog;
        }

    public Event getEvent(Event event) {
        return catalog.get(event.getId());
    }

    public Event getEvent(String id) {
        return catalog.get(id);
    }

    public boolean registerParticipant(String eventReferralId, Participant participant) {
        Event event = catalog.get(eventReferralId);
        return event.registerParticipant(participant);
    }
}
