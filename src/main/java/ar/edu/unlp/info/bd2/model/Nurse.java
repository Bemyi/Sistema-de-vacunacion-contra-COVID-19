package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
public class Nurse extends Personal implements Serializable, IModel{
    private Integer experience;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Nurse(String fullname, String dni, Integer experience) {
        super(fullname, dni);
        this.experience = experience;
    }

    public Nurse() {
        super();
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
