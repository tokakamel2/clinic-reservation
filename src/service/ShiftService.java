package service;

import model.Assistant;
import model.Doctor;
import model.Shift;
import repository.ShiftRepositoryImpl;
import util.DataTypes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ShiftService {
    ShiftRepositoryImpl shiftRepository = new ShiftRepositoryImpl();
    DoctorService doctorService = new DoctorService();
    AssistantService assistantService = new AssistantService();

    DataTypes.Day chooseDay(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose day: ");
        System.out.println("1. saturday");
        System.out.println("2. sunday");
        System.out.println("3. monday");
        System.out.println("4. tuesday");
        System.out.println("5. wednesday");
        System.out.println("6. thursday");
        System.out.println("7. friday");

        DataTypes.Day day = null;
        String chosenDay = scanner.nextLine();
        switch (chosenDay){
            case "1":
                day = DataTypes.Day.SATURDAY;
                break;
            case "2":
                day = DataTypes.Day.SUNDAY;
                break;
            case "3":
                day = DataTypes.Day.MONDAY;
                break;
            case "4":
                day = DataTypes.Day.TUESDAY;
                break;
            case "5":
                day = DataTypes.Day.WEDNESDAY;
                break;
            case "6":
                day = DataTypes.Day.THURSDAY;
                break;
            case "7":
                day = DataTypes.Day.FRIDAY;
                break;
            default:
                throw new RuntimeException ("invalid input");

        }
        return day;
    }
    List<Integer> fromTo (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting time in 24 hours format");
        int from = scanner.nextInt();
        if(from < 0 || from > 24){
            throw new RuntimeException("invalid input");
        }
        System.out.println("Enter ending time in 24 hours format");
        int to = scanner.nextInt();
        if(to < 0 || to > 24 || to <= from){
            throw new RuntimeException("invalid input");
        }
        List<Integer> fromTo = new ArrayList<>();
        fromTo.add(from);
        fromTo.add(to);
        return fromTo;

    }


    void createNewShift() throws SQLException {

        //choose doctor and get doctor id
        UUID doctorID = doctorService.chooseDoctor();

        //choose day
        DataTypes.Day day = chooseDay();

        //choose assistant and get assistant id
        UUID assistantID = assistantService.chooseAssistant();

        //choose from -> to
        List<Integer> fromTo = fromTo();
        int fromH = fromTo.get(0);
        int toH = fromTo.get(1);

        //create id
        UUID id =UUID.randomUUID();

        Shift shift = new Shift();
        shift.setId(id);
        shift.setDoctorID(doctorID);
        shift.setAssistantID(assistantID);
        shift.setDay(day);
        shift.setFrom(fromH);
        shift.setTo(toH);

        shiftRepository.addNew(shift);

    }
    List<Shift> findShiftByDayAndSpeciality(DataTypes.Day day, String speciality) throws SQLException {

       List<Shift> shiftsByDay= shiftRepository.findByDay(day.toString());

       List<Shift> shiftsByDayAndSpeciality = new ArrayList<>();
       for(int i=0; i<shiftsByDay.size(); i++){
          UUID doctorId = shiftsByDay.get(i).getDoctorID();
          Doctor doctor = doctorService.findById(doctorId);
          if(doctor.getSpeciality() == speciality){
              shiftsByDayAndSpeciality.add(shiftsByDay.get(i));
          }
       }
       return shiftsByDayAndSpeciality;
    }
}
