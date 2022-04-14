package service;

import model.AppUser;
import repository.AppUserRepositoryImpl;

import java.sql.SQLException;

public class AppUserService {

    AppUserRepositoryImpl appUserRepositoryImpl = new AppUserRepositoryImpl();

    public void login(String username, String password) throws SQLException {
       AppUser appUser = appUserRepositoryImpl.findByUserName(username);
       if(appUser != null && appUser.getUserName() != null && appUser.getPassword().equals(password)){
           System.out.println("successful login");
           System.out.println("you role is " + appUser.getRole());

           switch (appUser.getRole()){
               case ADMIN :
                   AdminService adminService = new AdminService();
                   adminService.displayMenu();
                   break;
               case DOCTOR:
                   DoctorService doctorService = new DoctorService();
                   doctorService.displayMenu();
                   break;
               case ASSISTANT:
                   AssistantService assistantService = new AssistantService();
                   assistantService.displayMenu();
                   break;
               case PATIENT:
                   PatientService patientService = new PatientService();
                   patientService.displayMenu(appUser.getId());
                   break;
               default:
                   System.out.println("error happened, Role is not valid");
           }
       }else{
           System.out.println("failed to login");
       }
    }
}
