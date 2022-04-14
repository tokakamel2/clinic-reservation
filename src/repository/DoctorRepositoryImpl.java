package repository;

import model.AppUser;
import model.Doctor;
import util.DataBaseConnectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoctorRepositoryImpl implements DoctorRepository{
    @Override
    public List<Doctor> findAll() throws SQLException {
        String sqlStatement= "SELECT * FROM DOCTOR ";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Doctor> doctors = new ArrayList<>();
        while ( resultSet.next() ) {
            Doctor doctor = new Doctor();

            String id = resultSet.getString("id");
            String  name = resultSet.getString("name");
            String password  = resultSet.getString("password");
            String  username1 = resultSet.getString("username");
            String role = resultSet.getString("role");
            String speciality = resultSet.getString("speciality");

            doctor.setUserName(username1);
            doctor.setName(name);
            doctor.setId(id);
            doctor.setPassword(password);
            doctor.setRole(role);
            doctor.setSpeciality(speciality);

            doctors.add(doctor);
        }
        return doctors;

    }

    @Override
    public Doctor findById(UUID idQ) throws SQLException {
        String sqlStatement= "SELECT * FROM DOCTOR WHERE ID = '"+idQ+"'";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Doctor> doctors = new ArrayList<>();
        while ( resultSet.next() ) {
            Doctor doctor = new Doctor();

            String id = resultSet.getString("id");
            String  name = resultSet.getString("name");
            String password  = resultSet.getString("password");
            String  username1 = resultSet.getString("username");
            String role = resultSet.getString("role");
            String speciality = resultSet.getString("speciality");

            doctor.setUserName(username1);
            doctor.setName(name);
            doctor.setId(id);
            doctor.setPassword(password);
            doctor.setRole(role);
            doctor.setSpeciality(speciality);

            doctors.add(doctor);
        }
        return doctors.get(0);
    }

    @Override
    public Doctor findBySpeciality(String specialityQ) throws SQLException {
        String sqlStatement= "SELECT * FROM DOCTOR WHERE SPECIALITY = '"+specialityQ+"'";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Doctor> doctors = new ArrayList<>();
        while ( resultSet.next() ) {
            Doctor doctor = new Doctor();

            String id = resultSet.getString("id");
            String  name = resultSet.getString("name");
            String password  = resultSet.getString("password");
            String  username1 = resultSet.getString("username");
            String role = resultSet.getString("role");
            String speciality = resultSet.getString("speciality");

            doctor.setUserName(username1);
            doctor.setName(name);
            doctor.setId(id);
            doctor.setPassword(password);
            doctor.setRole(role);
            doctor.setSpeciality(speciality);

            doctors.add(doctor);
        }
        return doctors.get(0);
    }

    @Override
    public void addNew(Doctor doctor) throws SQLException {
        String sqlStatement= "INSERT INTO DOCTOR "+
                "(id,name,username,password,role,phonenumber,speciality) "+
                "VALUES ( '"+doctor.getId()+"' , '"+doctor.getName()+"', '"+doctor.getUserName()+"', '"+doctor.getPassword()+"', '"+
                doctor.getRole()+"', '"+doctor.getPhoneNumber()+"', '"+doctor.getSpeciality()+"' )";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement.executeUpdate(sqlStatement);


    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Doctor updateRecord(UUID id) {
        return null;
    }

    @Override
    public Doctor findByUserName() {

        return null;
    }
}
