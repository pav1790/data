package controllers;

import models.Address;
import play.data.validation.Constraints;

import java.util.Date;
import java.util.Map;

public class EventData {

    @Constraints.Required
    private String title;

    @Constraints.Required
    private String street1;

    private String street2;

    @Constraints.Required
    private String city;

    @Constraints.Required
    private String state;

    @Constraints.Required
    private int zip;

    @Constraints.Required
    private String country;

    @Constraints.Required
    private String organizerId;

    @Constraints.Required
    private int participantCap;

    @Constraints.Required
    private String eventType;

    @Constraints.Required
    private double eventCost;

    @Constraints.Required
    private Date date;

    public EventData() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
