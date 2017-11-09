package models;

public class ParticipantDetails {

    private String shirtSize;
    private String estFinishTime;
    private boolean wheelChair = false;
    private String emergencyContact;
    private String emergencyContactNumber;
    private String medicalConditions;
    private String eventReferralId;
    private String runnerBibNumber;


    public ParticipantDetails(String eventReferralId, String shirtSize, String estFinishTime, boolean wheelChair, String emergencyContact,
                              String emergencyContactNumber, String medicalConditions) {
        this.eventReferralId = eventReferralId;
        this.shirtSize = shirtSize;
        this.estFinishTime = estFinishTime;
        this.wheelChair = wheelChair;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.medicalConditions = medicalConditions;
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
