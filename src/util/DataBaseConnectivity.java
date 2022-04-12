package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectivity {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";

    static final String user = "postgres";
    static final String password ="1234";

    static Connection connection = null;
    static Statement statement = null;

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
        statement.executeUpdate(sql);
        statement.close();
        connection.close();

    }catch (SQLException exception){
        exception.printStackTrace();
    }catch (Exception exception){
        exception.printStackTrace();
    }
    }

}
