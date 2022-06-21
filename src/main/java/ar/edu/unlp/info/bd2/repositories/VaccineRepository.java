package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
    Vaccine findByName(String name);
    @Query("select v " +
                  "from Vaccine as v " +
                  "where v.id not in(select s.vaccine.id from Shot as s)")
    List<Vaccine> getUnappliedVaccines();
}
