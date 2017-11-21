package models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Organizer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Address address;
    private List<Integer> eventIds;
    private String editKey = "secretKey";

    public Organizer(String firstName, String lastName, String email, String mobileNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public Long getId() {
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
