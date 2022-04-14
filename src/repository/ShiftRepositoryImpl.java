package repository;

import model.Shift;
import util.DataBaseConnectivity;

import java.sql.SQLException;
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
}
