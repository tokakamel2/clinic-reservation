package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSql {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";

    static final String user = "postgres";
    static final String password ="1234";

    static Connection connection = null;
    static Statement statement = null;

    public static void executeSql(String sql){
        try{
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL,user,password);

            statement= connection.createStatement();
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
