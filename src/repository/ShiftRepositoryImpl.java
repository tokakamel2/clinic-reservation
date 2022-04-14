package repository;

import model.Doctor;
import model.Shift;
import util.DataBaseConnectivity;
import util.DataTypes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShiftRepositoryImpl implements ShiftRepository{
    @Override
    public List<Shift> findAll() throws SQLException {
        return null;
    }

    @Override
    public Shift findById(UUID id) {
        return null;
    }

    @Override
    public void addNew(Shift shift) throws SQLException {
        String sqlStatement= "INSERT INTO SHIFT "+
                "(id,day,doctorID,assistantID,fromH,toH) "+
                "VALUES ( '"+shift.getId()+"' , '"+shift.getDay()+"', '"+shift.getDoctorID()+"', '"+shift.getAssistantID()+"', '"+
                shift.getFrom()+"', '"+shift.getTo()+"')";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement.executeUpdate(sqlStatement);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Shift updateRecord(UUID id) {
        return null;
    }

    @Override
    public List<Shift> findByDay(String selectDay) throws SQLException {
        String sqlStatement= "SELECT * FROM SHIFT WHERE DAY = '"+selectDay+"'";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Shift> shifts = new ArrayList<>();
        while ( resultSet.next() ) {
            Shift shift = new Shift();

            String id = resultSet.getString("id");
            int  from = resultSet.getInt("fromH");
            int to = resultSet.getInt("toH");
            String  day = resultSet.getString("day");
            String assistantID = resultSet.getString("assistantID");
            String doctorID = resultSet.getString("doctorID");

            shift.setId(UUID.fromString(id));
            shift.setFrom(from);
            shift.setTo(to);
            shift.setAssistantID(UUID.fromString(assistantID));
            shift.setDay(DataTypes.Day.valueOf(day));
            shift.setDoctorID(UUID.fromString(doctorID));


            shifts.add(shift);
        }
        return shifts;
    }
}
