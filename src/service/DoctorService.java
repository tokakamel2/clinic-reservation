package service;

import model.Doctor;
import repository.DoctorRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class DoctorService {

   DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl();

   void listAllDoctors() throws SQLException {
     List<Doctor> doctors= doctorRepository.findAll();

     for (int i=0; i<doctors.size();i++){
        System.out.println(i);
        System.out.println(doctors.get(i).getName());
     }
   }
   void addNewDoctor() throws SQLException {
       Doctor doctor = new Doctor();
       UUID id =UUID.randomUUID();
       doctor.setId(id.toString());
       doctorRepository.addNew(doctor);
   }
}
