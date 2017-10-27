package models;

import java.util.List;

public class Organizer extends Person {

    private List<Integer> eventIds;


    public Organizer(String firstName, String lastName, int day, String month, int year, String email, String mobileNumber, String gender) {
        super(firstName, lastName, day, month, year, email, mobileNumber, gender);
    }

    public void addEventOwnership(int eventId) {
        eventIds.add(eventId);
    }
}
