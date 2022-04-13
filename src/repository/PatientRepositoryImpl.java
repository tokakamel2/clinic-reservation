package repository;

import model.Doctor;
import model.Patient;
import util.DataBaseConnectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientRepositoryImpl implements PatientRepository{
    @Override
    public List<Patient> findAll() throws SQLException {
        String sqlStatement= "SELECT * FROM PATIENT ";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Patient> patients = new ArrayList<>();
        while ( resultSet.next() ) {
            Patient patient = new Patient();

            String id = resultSet.getString("id");
            String  name = resultSet.getString("name");
            String password  = resultSet.getString("password");
            String  username1 = resultSet.getString("username");
            String role = resultSet.getString("role");
            String speciality = resultSet.getString("speciality");

            patient.setUserName(username1);
            patient.setName(name);
            patient.setId(id);
            patient.setPassword(password);
            patient.setRole(role);


            patients.add(patient);
        }
        return patients;
    }

    @Override
    public Patient findById(UUID id) {
        return null;
    }

    @Override
    public void addNew(Patient patient) throws SQLException {
        String sqlStatement= "INSERT INTO PATIENT "+
                "(id,name,username,password,role,phonenumber,history,gender,age) "+
                "VALUES ( '"+patient.getId()+"' , '"+patient.getName()+"', '"+patient.getUserName()+"', '"+patient.getPassword()+"', '"+
                patient.getRole()+"', '"+patient.getPhoneNumber()+"', '"+patient.getHistory()+"', '"+patient.getGender()+"', '"+patient.getAge()+"')";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement.executeUpdate(sqlStatement);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Patient updateRecord(UUID id) {
        return null;
    }
}
