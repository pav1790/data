package models;

import helpers.IDMaker;

import java.util.*;

public class Event {

    private String id;
    private String title;
    private Date date;
    private Address address;
    private String organizerId;
    private Map<String, EventOption> eventOptions;
    private final String editKey = "secretKey";
    private List<String> participantIds;

    private Event(String title, String organizerId, Date date, Address address) {
        this.id = IDMaker.INSTANCE.getNewID();
        this.title = title;
        this.date = date;
        this.address = address;
        this.organizerId = organizerId;
        this.participantIds = new ArrayList<>();
    }

    public Event(String title, String organizerId, Date date, Address address, EventOption... eventOptions) {
        this(title, organizerId, date, address);
        if (eventOptions.length == 0) {
            throw new RuntimeException("Expected Event Options but got none");
        }
        Map<String, EventOption> eventOptionsMap = new HashMap<>();
        for (EventOption eventOption: eventOptions) {
            eventOptionsMap.put(IDMaker.INSTANCE.getNewID(), eventOption);
        }
        this.eventOptions = eventOptionsMap;
    }

    public Event(String title, String organizerId, Date date, Address address, Map<String, EventOption> eventOptions) {
        this.eventOptions = eventOptions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Address getAddress() {
        return address;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public Map<String, EventOption> getEventOptions() {
        return eventOptions;
    }

    public void updateEventOption(String optionId, EventOption eventOption) {
        this.eventOptions.put(optionId, eventOption);
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
