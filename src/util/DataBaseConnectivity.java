package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DataBaseConnectivity {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";

    static final String user = "postgres";
    static final String password ="1234";

    public static Connection connection = null;
    public static Statement statement = null;



    public static void connect() {
    try{
        Class.forName(JDBC_DRIVER);

        connection = DriverManager.getConnection(DB_URL,user,password);

        statement= connection.createStatement();
        String appUserSQL = "CREATE TABLE IF NOT EXISTS APPUSER" +
                "(id UUID not NULL, "+
                "name VARCHAR(255), "+
                "username VARCHAR(255), "+
                "password VARCHAR(255), "+
                "role VARCHAR(255), "+
                "phonenumber VARCHAR(255), "+
                "PRIMARY KEY ( id ))";
        String doctorSQL = "CREATE TABLE IF NOT EXISTS DOCTOR" +
                "(speciality VARCHAR(255) "+
                ") INHERITS (APPUSER)";
        String patientSQL = "CREATE TABLE IF NOT EXISTS PATIENT" +
                "(history VARCHAR(255), "+
                "age INT,"+
                "gender VARCHAR(255)"+
                ") INHERITS (APPUSER)";
        String assistantSQL = "CREATE TABLE IF NOT EXISTS ASSISTANT" +
                "( ) INHERITS (APPUSER)";
        String reservationSQL= "CREATE TABLE IF NOT EXISTS RESERVATION "+
                "(id UUID not NULL, "+
                "status BOOLEAN, "+
                "patientID VARCHAR(255), "+
                "assistantID VARCHAR(255), "+
                "doctorID VARCHAR(255), "+
                "PRIMARY KEY ( id ))";
        String shiftSQL= "CREATE TABLE IF NOT EXISTS SHIFT "+
                "(id UUID not NULL, "+
                "day VARCHAR(255), "+
                "doctorID VARCHAR(255), "+
                "assistantID VARCHAR(255), "+
                "fromH INT, "+
                "toH INT, "+
                "PRIMARY KEY ( id ))";


        statement.executeUpdate(appUserSQL);
        statement.executeUpdate(doctorSQL);
        statement.executeUpdate(assistantSQL);
        statement.executeUpdate(patientSQL);
        statement.executeUpdate(reservationSQL);
        statement.executeUpdate(shiftSQL);

        UUID id = UUID.randomUUID();
        String addAdmin = "INSERT INTO APPUSER "+
                "(id,name, username, password, role, phonenumber) "+
                "VALUES ('"+id+"' ,'admin','admin','admin','ADMIN', '01099999999')";
      //  statement. executeUpdate(addAdmin);
        statement.close();
      //  connection.close();

    }catch (SQLException exception){
        exception.printStackTrace();
    }catch (Exception exception){
        exception.printStackTrace();
    }
    }

}
