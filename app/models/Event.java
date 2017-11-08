package models;

import helpers.IDMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Event {

    private String id;
    private String title;
    private Address address;
    private Organizer organizer;
    private int participantCap;
    private Map<String, Double> eventOptions;
    private final String editKey = "secretKey";
    private List<String> participantIds;

    public Event(String title, Address address, Organizer organizer, int participantCap, Map<String, Double> eventOptions) {
        this.id = IDMaker.INSTANCE.getNewID();
        this.title = title;
        this.address = address;
        this.organizer = organizer;
        this.participantCap = participantCap;
        this.eventOptions = eventOptions;
        participantIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Address getAddress() {
        return address;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public int getParticipantCap() {
        return participantCap;
    }

    public Map<String, Double> getEventOptions() {
        return eventOptions;
    }

    public boolean registerParticipant(Participant participant) {
        if (participantIds.contains(participant.getId())){
            return false;
        }
        participantIds.add(participant.getId());
        return true;
    }

    public List<String> getParticipantIdList() {
        return this.participantIds;
    }

}
