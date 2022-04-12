package repository;

import java.util.List;
import java.util.UUID;

public interface CRUDOperations<type> {

    List<type> findAll();
    type findById(UUID id);
    void addNew();
    void deleteById(UUID id);
    type updateRecord(UUID id);
}
