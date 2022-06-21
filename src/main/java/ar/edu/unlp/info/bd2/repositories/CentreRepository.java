package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CentreRepository extends CrudRepository<Centre, Long> {
    Centre findByName(String name);
    Page<Centre> findAll(Pageable pageable);
}
