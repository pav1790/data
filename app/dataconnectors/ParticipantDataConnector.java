package dataconnectors;

import models.ParticipantDetails;
import models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// should switch to database interactions after this is working
public enum ParticipantDataConnector {
    INSTANCE;

    private Map<String, Person> catalog;

    public boolean registerParticipant(Person participant) {
        if (catalog == null) {
            catalog = new HashMap<>();
        }
        catalog.put(participant.getId(), participant);
        return true;
    }

    public Map<String, Person> getAllParticipants() {
        return catalog;
    }

    public List<Person> getParticipants(List<String> participantIds) {
        List<Person> participants = new ArrayList<>();
        for (String participantId : participantIds) {
            participants.add(getParticipant(participantId));
        }
        return participants;
    }

    /**
     * Used only for verifications. TODO - try to delete
     * @param participant
     * @return
     */
    public Person getParticipant(Person participant) {
        return catalog.get(participant.getId());
    }

    public Person getParticipant(String id) {
        return catalog.get(id);
    }

    public List<Person> getParticipantList(List<String> participantIds) {
        List<Person> participantsList = new ArrayList<>();
        for (String id : participantIds) {
            participantsList.add(getParticipant(id));
        }

        return participantsList;
    }

    public Person getParticipantViaEmail(String email) {
        for (String participantId : catalog.keySet()) {
            Person participant = catalog.get(participantId);
            if (participant.getEmail().equalsIgnoreCase(email)) {
                return participant;
            }
        }
        return null;
    }
}
