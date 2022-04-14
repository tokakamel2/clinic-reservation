package repository;

import model.Shift;

import java.sql.SQLException;
import java.util.List;

public interface ShiftRepository extends CRUDOperations<Shift>{

    List<Shift> findByDay(String day) throws SQLException;
}
