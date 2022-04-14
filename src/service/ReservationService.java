package service;

import model.Doctor;
import model.Reservation;
import model.Shift;
import repository.ReservationRepositoryImpl;
import util.DataTypes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ReservationService {

    ReservationRepositoryImpl reservationRepository = new ReservationRepositoryImpl();
    DoctorService doctorService = new DoctorService();

    ShiftService shiftService = new ShiftService();



    void addNewReservation(UUID patientID) throws SQLException {
        //choose speciality
        String speciality = doctorService.chooseSpeciality();
        //choose day
        DataTypes.Day day = shiftService.chooseDay();
        //choose shifts with speciality and day
       List<Shift> shifts = shiftService.findShiftByDayAndSpeciality(day,speciality);

        System.out.println("choose desired doctor to reserve");
        for(int i=0; i<shifts.size();i++){
            System.out.println(i+1);
            Doctor doctor = doctorService.findById(shifts.get(i).getDoctorID());
            System.out.println(doctor.getName());
            System.out.println("starting: "+ shifts.get(i).getFrom()+ " ending: "+ shifts.get(i).getTo());

        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice<1 || choice>shifts.size()){
            throw new RuntimeException("invalid input");
        }
        //make a reservation
        Reservation reservation = new Reservation();
        reservation.setPatientID(patientID);
        reservation.setId(UUID.randomUUID());
        reservation.setStatus(true);
        reservation.setAssistantID(shifts.get(choice-1).getAssistantID());
        reservation.setDoctorID(shifts.get(choice-1).getDoctorID());
        reservation.setShiftID(shifts.get(choice-1).getId());

    }
}
