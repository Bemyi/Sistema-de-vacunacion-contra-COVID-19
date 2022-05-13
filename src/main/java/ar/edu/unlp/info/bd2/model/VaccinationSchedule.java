package ar.edu.unlp.info.bd2.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class VaccinationSchedule implements Serializable, IModel {
    @NaturalId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "vaccinationSchedule_vaccine",
            joinColumns = {@JoinColumn(name = "vaccinationSchedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "vaccine_id")}
    )
    private List<Vaccine> vaccines = new ArrayList<>();

    public VaccinationSchedule(){
    }

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