package service;

import model.Assistant;
import model.Doctor;
import repository.AssistantRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AssistantService {
    AssistantRepositoryImpl assistantRepository = new AssistantRepositoryImpl();
    PatientService patientService = new PatientService();

    void displayMenu() throws SQLException {
        System.out.println("choose the action you want to do: ");
        System.out.println("1. add new patient");
        System.out.println("2. update patient");
        System.out.println("3. list today's reservations ");
        Scanner scanner = new Scanner(System.in);
        String choice =scanner.nextLine();
        switch(choice){
            case "1":
                patientService.addNewPatient();
                displayMenu();
                break;
            case "2":

        }
    }

    void listAllAssistants() throws SQLException {
        List<Assistant> assistants= assistantRepository.findAll();

        for (int i=0; i<assistants.size();i++){
            System.out.println(i);
            System.out.println(assistants.get(i).getName());
        }
    }
    List<Assistant> getAllAssistants() throws SQLException {
        return assistantRepository.findAll();
    }
    void addNewAssistant() throws SQLException {
        Assistant assistant = new Assistant();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();

        UUID id =UUID.randomUUID();

        assistant.setId(id.toString());
        assistant.setName(name);
        assistant.setUserName(username);
        assistant.setPassword(password);
        assistant.setPhoneNumber(phone);
        assistant.setRole("ASSISTANT");
        assistantRepository.addNew(assistant);
    }
    UUID chooseAssistant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        List<Assistant> assistants = getAllAssistants();
        for(int i=0; i< assistants.size() ;i++){
            System.out.println(i+1 + assistants.get(i).getName());
        }
        int choice = scanner.nextInt();
        if(choice-1 <0 || choice-1 >= assistants.size()){
            throw new RuntimeException("invalid input");
        }
        UUID assistantID = assistants.get(choice-1).getId();
        return assistantID;
    }
}
