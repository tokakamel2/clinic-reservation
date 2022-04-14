package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public interface CRUDOperations<type> {


    List<type> findAll() throws SQLException;
    type findById(UUID id) throws SQLException;

    void addNew(type type) throws SQLException;
    void deleteById(UUID id);
    type updateRecord(UUID id);
}
