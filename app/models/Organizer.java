package models;

import java.util.List;

public class Organizer extends Person {

    private List<Integer> eventIds;
    private String editKey = "secretKey";


    public Organizer(String firstName, String lastName, DateOfBirth dateOfBirth, String email, String mobileNumber, String gender, Address address) {
        super(firstName, lastName, dateOfBirth, email, mobileNumber, gender, address);
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
