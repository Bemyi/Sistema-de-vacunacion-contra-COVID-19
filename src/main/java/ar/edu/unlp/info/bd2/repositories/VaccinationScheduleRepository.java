package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationScheduleRepository extends CrudRepository<VaccinationSchedule, Long> {
}
