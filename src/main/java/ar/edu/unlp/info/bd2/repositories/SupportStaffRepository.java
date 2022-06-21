package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupportStaffRepository extends CrudRepository<SupportStaff, Long> {
    SupportStaff findByDni(String dni);

    @Query("select s.area " +
            "from SupportStaff as s " +
            "group by s.area " +
            "order by count(s.area) asc")
    List getLessEmployeesSupportStaffArea(Pageable pag);
}
