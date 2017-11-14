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
    private int participantCap1;
    private int participantCap2;
    private int participantCap3;

    @Constraints.Required
    private String eventType1;
    private String eventType2;
    private String eventType3;

    @Constraints.Required
    private double eventCost1;
    private double eventCost2;
    private double eventCost3;

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

    public int getParticipantCap1() {
        return participantCap1;
    }

    public void setParticipantCap1(int participantCap1) {
        this.participantCap1 = participantCap1;
    }

    public int getParticipantCap2() {
        return participantCap2;
    }

    public void setParticipantCap2(int participantCap2) {
        this.participantCap2 = participantCap2;
    }

    public int getParticipantCap3() {
        return participantCap3;
    }

    public void setParticipantCap3(int participantCap3) {
        this.participantCap3 = participantCap3;
    }

    public String getEventType1() {
        return eventType1;
    }

    public void setEventType1(String eventType1) {
        this.eventType1 = eventType1;
    }

    public String getEventType2() {
        return eventType2;
    }

    public void setEventType2(String eventType2) {
        this.eventType2 = eventType2;
    }

    public String getEventType3() {
        return eventType3;
    }

    public void setEventType3(String eventType3) {
        this.eventType3 = eventType3;
    }

    public double getEventCost1() {
        return eventCost1;
    }

    public void setEventCost1(double eventCost1) {
        this.eventCost1 = eventCost1;
    }

    public double getEventCost2() {
        return eventCost2;
    }

    public void setEventCost2(double eventCost2) {
        this.eventCost2 = eventCost2;
    }

    public double getEventCost3() {
        return eventCost3;
    }

    public void setEventCost3(double eventCost3) {
        this.eventCost3 = eventCost3;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
