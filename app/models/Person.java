package models;

import helpers.IDMaker;

/**
 * Contains data on a typical person
 */
public abstract class Person {

    private final String id;
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;
    private Address address;
    private String email;
    private int mobileNumber;
    private char gender;

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
