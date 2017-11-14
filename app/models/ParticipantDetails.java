package models;

import java.util.HashMap;
import java.util.Map;

public class ParticipantDetails {

    private String eventReferralId;
    private Map<String, String> subEventIdsAndTimes = new HashMap<>();
    private String shirtSize;
    private boolean wheelChair = false;
    private String emergencyContact;
    private String emergencyContactNumber;
    private String medicalConditions;
    private String runnerBibNumber;


    public ParticipantDetails(String eventReferralId, String shirtSize, String subEventId, String estFinishTime, boolean wheelChair, String emergencyContact,
                              String emergencyContactNumber, String medicalConditions) {
        this.eventReferralId = eventReferralId;
        this.shirtSize = shirtSize;
        this.subEventIdsAndTimes.put(subEventId, estFinishTime);
        this.wheelChair = wheelChair;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.medicalConditions = medicalConditions;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public Map<String, String> getSubEventIdsAndTimes() {
        return subEventIdsAndTimes;
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
