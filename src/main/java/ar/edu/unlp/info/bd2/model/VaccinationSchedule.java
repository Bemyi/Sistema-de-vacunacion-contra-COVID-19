package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.util.Collection;
import java.util.List;

public class VaccinationSchedule {
    private List vaccines; // Collecion tiraba error al hacer un .get(posición). Ver si usar esto o ArrayList
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public List getVaccines() {
        return vaccines;
    }

    public void addVaccine(Vaccine vaccine) {
        this.vaccines.add(vaccine);
    }
}