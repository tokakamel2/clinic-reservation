package repository;

import model.Assistant;
import model.Doctor;
import util.DataBaseConnectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AssistantRepositoryImpl implements AssistantRepository{
    @Override
    public List<Assistant> findAll() throws SQLException {
        String sqlStatement= "SELECT * FROM ASSISTANT ";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        ResultSet resultSet = DataBaseConnectivity.statement.executeQuery(sqlStatement);

        List<Assistant> assistants = new ArrayList<>();
        while ( resultSet.next() ) {
            Assistant assistant = new Assistant();

            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String username1 = resultSet.getString("username");
            String role = resultSet.getString("role");


            assistant.setUserName(username1);
            assistant.setName(name);
            assistant.setId(id);
            assistant.setPassword(password);
            assistant.setRole(role);


            assistants.add(assistant);
        }
        return assistants;
    }

    @Override
    public Assistant findById(UUID id) {
        return null;
    }

    @Override
    public void addNew(Assistant assistant) throws SQLException {
        String sqlStatement= "INSERT INTO ASSISTANT "+
                "(id,name,username,password,role,phonenumber) "+
                "VALUES ( '"+assistant.getId()+"' , '"+assistant.getName()+"', '"+assistant.getUserName()+"', '"+assistant.getPassword()+"', '"+
                assistant.getRole()+"', '"+assistant.getPhoneNumber()+"' )";
        DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement = DataBaseConnectivity.connection.createStatement();
        DataBaseConnectivity.statement.executeUpdate(sqlStatement);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Assistant updateRecord(UUID id) {
        return null;
    }
}
