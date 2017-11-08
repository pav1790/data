package dataconnectors;

import models.Participant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// should switch to database interactions after this is working
public enum ParticipantDataConnector {
    INSTANCE;

    private Map<String, Participant> catalog;

    public boolean registerParticipant(Participant participant) {
        if (catalog == null) {
            catalog = new HashMap<>();
        }
        catalog.put(participant.getId(), participant);
        return true;
    }

    public Map<String, Participant> getAllParticipants() {
        return catalog;
    }

    public Participant getParticipant(Participant participant) {
        return catalog.get(participant.getId());
    }

    public Participant getParticipant(String id) {
        return catalog.get(id);
    }

    public List<Participant> getParticipantList(List<String> participantIds) {
        List<Participant> participantsList = new ArrayList<>();
        for (String id : participantIds) {
            participantsList.add(getParticipant(id));
        }

        return participantsList;
    }

    public Participant getParticipantViaEmail(String email) {
        for (String participantId : catalog.keySet()) {
            Participant participant = catalog.get(participantId);
            if (participant.getEmail().equalsIgnoreCase(email)) {
                return participant;
            }
        }
        return null;
    }
}
