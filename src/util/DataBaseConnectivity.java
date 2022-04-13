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
        String sql = "CREATE TABLE IF NOT EXISTS APPUSER" +
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

        statement.executeUpdate(sql);
        statement.executeUpdate(doctorSQL);
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
