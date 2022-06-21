package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface CentreRepository extends CrudRepository<Centre, Long> {
    Centre findByName(String name);
}
