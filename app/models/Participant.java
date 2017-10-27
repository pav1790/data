package models;

public class Participant extends Person {

    private String shirtSize;
    private String estFinishTime;
    private boolean wheelChair = false;
    private String emergencyContact;
    private String emergencyContactNumber;
    private String medicalConditions;
    private String eventReferral;


    public Participant(String firstName, String lastName, int day, String month, int year, String email,
                       String mobileNumber, String gender, String shirtSize, String estFinishTime, boolean wheelChair,
                       String emergencyContact, String emergencyContactNumber, String medicalConditions, String eventReferral) {
        super(firstName, lastName, day, month, year, email, mobileNumber, gender);
        this.shirtSize = shirtSize;
        this.estFinishTime = estFinishTime;
        this.wheelChair = wheelChair;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.medicalConditions = medicalConditions;
        this.eventReferral = eventReferral;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public String getEstFinishTime() {
        return estFinishTime;
    }

    public boolean isWheelChair() {
        return wheelChair;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public String getEventReferral() {
        return eventReferral;
    }
}
