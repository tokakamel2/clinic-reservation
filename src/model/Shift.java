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

}
