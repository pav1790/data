package models;

import helpers.IDMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Event {

    private String id;
    private String title;
    private Address address;
    private String organizerId;
    private int participantCap;
    private String eventType;
    private double eventCost;
    private final String editKey = "secretKey";
    private List<String> participantIds;

    public Event(String title, Address address, String organizerId, int participantCap, String eventType, double eventCost) {
        this.id = IDMaker.INSTANCE.getNewID();
        this.title = title;
        this.address = address;
        this.organizerId = organizerId;
        this.participantCap = participantCap;
        this.eventType = eventType;
        this.eventCost = eventCost;
        this.participantIds = new ArrayList<>();
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

    public String getOrganizerId() {
        return organizerId;
    }

    public int getParticipantCap() {
        return participantCap;
    }

    public String getEventType() {
        return eventType;
    }

    public double getEventCost() {
        return eventCost;
    }

    public boolean registerParticipant(Person participant) {
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
