package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, Long> {
    List<Staff> getAllByFullNameContaining(String name);
}
