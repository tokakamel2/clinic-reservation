package service;

import model.Doctor;
import repository.DoctorRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
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
       Scanner scanner = new Scanner(System.in);

       Doctor doctor = new Doctor();
       System.out.println("Enter name: ");
       String name = scanner.nextLine();
       System.out.println("Enter username: ");
       String username = scanner.nextLine();
       System.out.println("Enter password: ");
       String password = scanner.nextLine();
       System.out.println("Enter phone number: ");
       String phone = scanner.nextLine();
       System.out.println("Enter speciality: ");
       String speciality = scanner.nextLine();

       UUID id =UUID.randomUUID();

       doctor.setId(id.toString());
       doctor.setName(name);
       doctor.setUserName(username);
       doctor.setPassword(password);
       doctor.setSpeciality(speciality);
       doctor.setPhoneNumber(phone);
       doctor.setRole("DOCTOR");
       doctorRepository.addNew(doctor);
   }
}
