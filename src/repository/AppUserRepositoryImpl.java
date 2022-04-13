package repository;

import model.AppUser;
import util.DataBaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class AppUserRepositoryImpl implements AppUserRepository{


    @Override
    public AppUser findByUserName(String username) throws SQLException {
        String sqlStatement= "SELECT * FROM APPUSER WHERE USERNAME = '" + username+"'";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        AppUser appUser = new AppUser();
        while ( resultSet.next() ) {
            String id = resultSet.getString("id");
            String  name = resultSet.getString("name");
            String password  = resultSet.getString("password");
            String  username1 = resultSet.getString("username");
            String role = resultSet.getString("role");

            appUser.setUserName(username1);
            appUser.setName(name);
            appUser.setId(id);
            appUser.setPassword(password);
            appUser.setRole(role);
        }
        return appUser;
    }

    @Override
    public List findAll() {

        return null;
    }

    @Override
    public Object findById(UUID id) {
        return null;
    }

    @Override
    public void addNew(Object o) throws SQLException {

    }


    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Object updateRecord(UUID id) {
        return null;
    }
}
