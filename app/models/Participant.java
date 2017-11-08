package models;

public class Participant extends Person {

    private String shirtSize;
    private String estFinishTime;
    private boolean wheelChair = false;
    private String emergencyContact;
    private String emergencyContactNumber;
    private String medicalConditions;
    private String eventReferralId;
    private String runnerBibNumber;


    public Participant(String firstName, String lastName, DateOfBirth dateOfBirth, String email,
                       String mobileNumber, String gender, Address address, String shirtSize, String estFinishTime, boolean wheelChair,
                       String emergencyContact, String emergencyContactNumber, String medicalConditions, String eventReferralId) {
        super(firstName, lastName, dateOfBirth, email, mobileNumber, gender, address);
        this.shirtSize = shirtSize;
        this.estFinishTime = estFinishTime;
        this.wheelChair = wheelChair;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.medicalConditions = medicalConditions;
        this.eventReferralId = eventReferralId;
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

    public String getEventReferralId() {
        return eventReferralId;
    }

    public String getRunnerBibNumber() {
        return runnerBibNumber;
    }

    public void setRunnerBibNumber(String runnerBibNumber) {
        this.runnerBibNumber = runnerBibNumber;
    }
}
