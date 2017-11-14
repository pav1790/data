package models;

public class EventOption {
    private int participantCap;
    private String eventType;
    private double eventCost;

    public EventOption(int participantCap, String eventType, double eventCost) {
        this.participantCap = participantCap;
        this.eventType = eventType;
        this.eventCost = eventCost;
    }

    public int getParticipantCap() {
        return participantCap;
    }

    public void setParticipantCap(int participantCap) {
        this.participantCap = participantCap;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public double getEventCost() {
        return eventCost;
    }

    public void setEventCost(double eventCost) {
        this.eventCost = eventCost;
    }
}
