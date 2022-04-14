package repository;

import model.Doctor;

import java.sql.SQLException;
import java.util.UUID;

public interface DoctorRepository extends CRUDOperations<Doctor>{

 Doctor findByUserName();
 Doctor findBySpeciality(String specialityQ) throws SQLException;
}
