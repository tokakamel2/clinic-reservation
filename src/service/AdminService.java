package service;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {

    public void displayMenu() throws SQLException {
        System.out.println("Enter the number of the choice of the action you want: ");
        System.out.println("1. List all doctors");
        System.out.println("2. List all assistants");
        System.out.println("3. List all patients");
        System.out.println("4. add new doctor");
        System.out.println("5. add new assistant");
        System.out.println("6. update doctor");
        System.out.println("7. update assistant");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        DoctorService doctorService = new DoctorService();
        AssistantService assistantService = new AssistantService();
        switch (choice){
            case "1":
                doctorService.listAllDoctors();
                displayMenu();
                break;
            case "2":
                assistantService.listAllAssistants();
                displayMenu();
                break;
            case "4":
                doctorService.addNewDoctor();
                displayMenu();
                break;
            case "5":
                assistantService.addNewAssistant();
                displayMenu();
                break;
            default:
                System.out.println("invalid input");
                displayMenu();
        }

    }

}
