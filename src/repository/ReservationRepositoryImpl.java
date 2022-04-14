package repository;

import model.Reservation;
import util.DataBaseConnectivity;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ReservationRepositoryImpl implements ReservationRepository{
    @Override
    public List<Reservation> findAll() throws SQLException {
        return null;
    }

    @Override
    public Reservation findById(UUID id) {
        return null;
    }

    @Override
    public void addNew(Reservation reservation) throws SQLException {
        String sqlStatement= "INSERT INTO RESERVATION "+
                "(id,status,doctorID,assistantID,patientID) "+
                "VALUES ( '"+reservation.getId()+"' , "+reservation.isStatus()+", '"+reservation.getDoctorID()+"', '"+reservation.getAssistantID()+"', '"+
                reservation.getPatientID()+"')";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement.executeUpdate(sqlStatement);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Reservation updateRecord(UUID id) {
        return null;
    }

}
