package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Nurse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseRepository extends CrudRepository<Nurse, Long> {
    List<Nurse> findByExperienceGreaterThan(int years);

    @Query("select n " +
                  "from Nurse as n " +
                  "where n.id not in(select s.nurse.id from Shot as s)")
    List<Nurse> getNurseNotShot();
}
