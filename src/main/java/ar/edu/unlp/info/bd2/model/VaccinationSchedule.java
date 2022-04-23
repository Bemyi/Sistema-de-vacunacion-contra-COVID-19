package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.util.Collection;

public class VaccinationSchedule {
    private Collection vaccines;
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public Collection getVaccines() {
        return vaccines;
    }

    public void addVaccine(Vaccine vaccine) {
        this.vaccines.add(vaccine);
    }
}