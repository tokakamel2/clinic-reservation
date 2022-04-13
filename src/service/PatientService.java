package service;

import model.Doctor;
import model.Patient;
import repository.DoctorRepositoryImpl;
import repository.PatientRepositoryImpl;
import util.DataTypes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PatientService {

    PatientRepositoryImpl patientRepository = new PatientRepositoryImpl();

    void displayMenu(){
        System.out.println("choose the action you want to do: ");
        System.out.println("1. list all doctors");
        System.out.println("2. list all specialities ");
        System.out.println("3. make a reservation ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    void listAllPatients() throws SQLException {
        List<Patient> patients= patientRepository.findAll();

        for (int i=0; i<patients.size();i++){
            System.out.println(i);
            System.out.println(patients.get(i).getName());
        }
    }
    void addNewPatient() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Patient patient = new Patient();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Enter medical history: ");
        String history = scanner.nextLine();
        System.out.println("Enter Gender:");
        System.out.println("1.MALE");
        System.out.println("2.FEMALE");
        String choice = scanner.nextLine();
        DataTypes.Gender gender = null;
        switch (choice){
            case "1":
                 gender = DataTypes.Gender.MALE;
                 break;
            case "2":
                 gender = DataTypes.Gender.FEMALE;
                 break;
            default:
                System.out.println("invalid option");
                System.out.println("Re-Enter all data again");
                addNewPatient();
        }


        UUID id =UUID.randomUUID();

        patient.setId(id.toString());
        patient.setName(name);
        patient.setUserName(username);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setPhoneNumber(phone);
        patient.setHistory(history);
        patient.setGender(gender);
        patient.setRole("PATIENT");
        patientRepository.addNew(patient);
    }
}
