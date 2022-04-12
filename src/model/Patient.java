package model;

public class Patient extends AppUser{

    enum Gender {MALE,FEMALE}

    private String history;
    private int age;
    private Gender gender;

}
