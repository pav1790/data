package models;

public class Person {

    private final String id;
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;
    private Address address;
    private String email;
    private int mobileNumber;
    private char gender;

    public Person(String firstName, String lastName, int day, String month, int year, String email, String mobileNumber, String gender,
                  String street1, String street2, String city, String state, int zip, String country) {
        this.id = "1";
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new DateOfBirth(day, month, year);
        this.address = new Address(street1, street2, city, state, zip, country);
        this.email = email;
        mobileNumber = mobileNumber.replaceAll("-", ""); // TODO - fix regex for any symbol
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
