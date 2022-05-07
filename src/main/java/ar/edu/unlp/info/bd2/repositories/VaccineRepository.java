package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {

    Vaccine getByName(String name);

}
