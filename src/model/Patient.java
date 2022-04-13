package model;

import util.DataTypes;

public class Patient extends AppUser{

    private String history;
    private int age;
    private DataTypes.Gender gender;

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DataTypes.Gender getGender() {
        return gender;
    }

    public void setGender(DataTypes.Gender gender) {
        this.gender = gender;
    }
}
