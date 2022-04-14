package service;

import model.Doctor;
import repository.DoctorRepositoryImpl;

import javax.print.Doc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DoctorService {

   DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl();

   void displayMenu(){
       System.out.println("choose the action you want to do: ");
       System.out.println("1. list today's reservations");
       System.out.println("2. mark reservation as done");
       Scanner scanner = new Scanner(System.in);
       scanner.nextLine();
   }

   void listAllDoctors() throws SQLException {
     List<Doctor> doctors= doctorRepository.findAll();

     for (int i=0; i<doctors.size();i++){
        System.out.println(i);
        System.out.println(doctors.get(i).getName());
     }
   }
    List<Doctor> getAllDoctors() throws SQLException {
        return doctorRepository.findAll();
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
   void updateDoctor(){
       Scanner scanner = new Scanner(System.in);

       Doctor doctor = new Doctor();
       System.out.println("Enter the number the action you want: ");
       System.out.println("1. change name");
       System.out.println("2. change speciality");
       System.out.println("3. change phone number");
       String choice = scanner.nextLine();
       switch (choice){
           case "1":

       }
   }
    void listAllSpecialities() throws SQLException {
      List<Doctor> doctors =  doctorRepository.findAll();
      List<String> specialities =new ArrayList<>();
      specialities.add(doctors.get(0).getSpeciality());

      for(int i = 0; i<doctors.size();i++){
          if(!specialities.contains(doctors.get(i).getSpeciality())){
              specialities.add(doctors.get(i).getSpeciality());

          }
      }
      for(int i=0; i<specialities.size();i++){
          System.out.println(i+1+" "+ specialities.get(i));

      }

    }
    UUID chooseDoctor() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<Doctor> doctors=  getAllDoctors();
        for(int i=0; i< doctors.size() ;i++){
            System.out.println(i+1 + doctors.get(i).getName());
        }
        System.out.println("Enter the number of the doctor you want to add shift to: ");
        int choice = scanner.nextInt();
        if(choice-1 <0 || choice-1 >= doctors.size()){
            throw new RuntimeException("invalid input");
        }
        UUID doctorID = doctors.get(choice-1).getId();
        return doctorID;
    }
}
