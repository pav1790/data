package controllers;

import play.data.validation.Constraints;

public class ParticipantEventData extends ParticipantData {

    @Constraints.Required
    private String shirtSize;

    @Constraints.Required
    private String estFinishTime;

    @Constraints.Required
    private boolean wheelChair;

    @Constraints.Required
    private String emergencyContact;

    @Constraints.Required
    private String emergencyContactNumber;

    private String medicalConditions;

    @Constraints.Required
    private String eventReferralId;

    private String runnerBibNumber;


    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        this.shirtSize = shirtSize;
    }

    public String getEstFinishTime() {
        return estFinishTime;
    }

    public void setEstFinishTime(String estFinishTime) {
        this.estFinishTime = estFinishTime;
    }

    public boolean isWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(boolean wheelChair) {
        this.wheelChair = wheelChair;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getEventReferralId() {
        return eventReferralId;
    }

    public void setEventReferralId(String eventReferralId) {
        this.eventReferralId = eventReferralId;
    }

    public String getRunnerBibNumber() {
        return runnerBibNumber;
    }

    public void setRunnerBibNumber(String runnerBibNumber) {
        this.runnerBibNumber = runnerBibNumber;
    }
}
