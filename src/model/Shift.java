package model;


import util.DataTypes;

import java.util.UUID;

public class Shift {



    private UUID id;
    private DataTypes.Day day;
    private UUID doctorID;
    private UUID assistantID;
    private int from;
    private int to;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DataTypes.Day getDay() {
        return day;
    }

    public void setDay(DataTypes.Day day) {
        this.day = day;
    }

    public UUID getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(UUID doctorID) {
        this.doctorID = doctorID;
    }

    public UUID getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(UUID assistantID) {
        this.assistantID = assistantID;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }



}
