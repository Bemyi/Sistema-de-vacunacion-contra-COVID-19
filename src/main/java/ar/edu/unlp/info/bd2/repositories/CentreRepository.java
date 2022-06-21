package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CentreRepository extends CrudRepository<Centre, Long> {
    Centre findByName(String name);

    @Query("select c from Centre as c order by size(c.staff) desc")
    List<Centre> getCentresTopNStaff(Pageable pageable);

    @Query("select new Centre (s.centre.name)" +
            "from Shot as s "+
            "group by s.centre "+
            "order by count(s.centre.id) desc")
    List<Centre> getTopShotCentre();
}
