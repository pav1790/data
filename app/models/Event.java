package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private Date date;
    private Address address;
    private String organizerId;
    private Map<Integer, EventOption> eventOptions;
    private final String editKey = "secretKey";
    private List<Long> participantIds;

    private Event(String title, String organizerId, Date date, Address address) {
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
        Map<Integer, EventOption> eventOptionsMap = new HashMap<>();
        for (EventOption eventOption: eventOptions) {
            eventOptionsMap.put(eventOptionsMap.size()+1, eventOption);
        }
        this.eventOptions = eventOptionsMap;
    }

    public Event(String title, String organizerId, Date date, Address address, Map<Integer, EventOption> eventOptions) {
        this.eventOptions = eventOptions;
    }

    public Long getId() {
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

    public Map<Integer, EventOption> getEventOptions() {
        return eventOptions;
    }

    public void updateEventOption(Integer optionId, EventOption eventOption) {
        this.eventOptions.put(optionId, eventOption);
    }

    public boolean registerParticipant(Person participant) {
        if (participantIds.contains(participant.getId())){
            return false;
        }
        participantIds.add(participant.getId());
        return true;
    }

    public List<Long> getParticipantIdList() {
        return this.participantIds;
    }

}
