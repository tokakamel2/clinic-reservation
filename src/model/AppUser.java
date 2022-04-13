package model;



import com.sun.jdi.ObjectReference;
import util.DataTypes;

import java.util.UUID;

public class AppUser {

    private UUID id;
    private String name;
    private String password;
    private String userName;
    private DataTypes.Role role;
    private String phoneNumber;

    public UUID getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DataTypes.Role getRole() {
        return role;
    }

    public void setRole(String role) {

        this.role =  DataTypes.Role.valueOf(role);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
