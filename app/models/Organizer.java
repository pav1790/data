package models;

import helpers.IDMaker;

import java.util.List;

public class Organizer {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Address address;
    private List<Integer> eventIds;
    private String editKey = "secretKey";

    public Organizer(String firstName, String lastName, String email, String mobileNumber, Address address) {
        this.id = IDMaker.INSTANCE.getNewID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public List<Integer> getEventIds() {
        return eventIds;
    }

    public void addEventOwnership(int eventId) {
        eventIds.add(eventId);
    }

    /**
     * Should be used rarely
     * @param eventId
     */
    public void removeEventOwnership(int eventId) {
        eventIds.remove(eventId);
    }

}
