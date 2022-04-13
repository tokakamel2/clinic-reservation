package repository;

import model.AppUser;

import java.sql.SQLException;

public interface AppUserRepository extends CRUDOperations{

    AppUser findByUserName(String username) throws SQLException;
}
