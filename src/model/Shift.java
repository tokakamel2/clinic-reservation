package model;


import java.util.UUID;

public class Shift {

    enum Day {SATURDAY,SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY}

    private UUID id;
    private Day day;
    private Doctor doctor;
    private int from;
    private int to;

}
