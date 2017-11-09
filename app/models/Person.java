package models;

import helpers.IDMaker;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains data on a typical person
 */
public class Person {

    private final String id;
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;
    private Address address;
    private String email;
    private int mobileNumber;
    private char gender;
    private Map<String, ParticipantDetails> eventDetails;

    /**
     * Used for keeping track of personal data on participants and event organizers
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param email
     * @param mobileNumber
     * @param gender
     * @param address
     */
    public Person(String firstName, String lastName, DateOfBirth dateOfBirth, String email, String mobileNumber, String gender, Address address) {
        this.id = IDMaker.INSTANCE.getNewID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        mobileNumber = mobileNumber.replaceAll("-\\(\\)", ""); // TODO - fix regex for any symbol
        this.mobileNumber = Integer.parseInt(mobileNumber);
        this.gender = gender.charAt(0);
        eventDetails = new HashMap<>();
    }

    public Person(String firstName, String lastName, DateOfBirth dateOfBirth, String email, String mobileNumber, String gender, Address address,
                  String shirtSize, String estFinishTime, boolean wheelChair, String emergencyContact, String emergencyContactNumber, String medicalConditions, String eventReferralId) {
        this(firstName, lastName, dateOfBirth, email, mobileNumber, gender, address);
        addEventDetails(eventReferralId, shirtSize, estFinishTime, wheelChair, emergencyContact, emergencyContactNumber, medicalConditions);
    }

    public boolean addEventDetails(String eventReferralId, String shirtSize, String estFinishTime, boolean wheelChair,
                                   String emergencyContact, String emergencyContactNumber, String medicalConditions) {
        ParticipantDetails participantDetails = new ParticipantDetails(shirtSize, estFinishTime, wheelChair, emergencyContact, emergencyContactNumber, medicalConditions);
        eventDetails.put(eventReferralId, participantDetails);
        return true;
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

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public char getGender() {
        return gender;
    }
}
