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

    void listAllAssistants() throws SQLException {
        List<Assistant> assistants= assistantRepository.findAll();

        for (int i=0; i<assistants.size();i++){
            System.out.println(i);
            System.out.println(assistants.get(i).getName());
        }
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
}
