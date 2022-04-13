import service.AppUserService;
import util.DataBaseConnectivity;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
       displayLogin();
    }
    private static void displayLogin() throws SQLException {
        DataBaseConnectivity.connect();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Login First! ");
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your Password: ");
        String password = scanner.nextLine();

        AppUserService appUserService = new AppUserService();

        appUserService.login(username,password);

        System.out.println("you are not logged in");
        displayLogin();



    };
}
