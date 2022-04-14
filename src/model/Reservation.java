package model;

import java.util.UUID;

public class Reservation {

    private UUID id;
    private boolean status;
    private UUID patientID;
    private UUID assistantID;
    private UUID doctorID;
    private UUID shiftID;

    public UUID getShiftID() {
        return shiftID;
    }

    public void setShiftID(UUID shiftID) {
        this.shiftID = shiftID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getPatientID() {
        return patientID;
    }

    public void setPatientID(UUID patientID) {
        this.patientID = patientID;
    }

    public UUID getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(UUID assistantID) {
        this.assistantID = assistantID;
    }

    public UUID getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(UUID doctorID) {
        this.doctorID = doctorID;
    }
}
