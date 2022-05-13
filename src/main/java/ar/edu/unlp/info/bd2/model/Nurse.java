package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
@Entity
@DiscriminatorValue("2")
public class Nurse extends Personal{
    private Integer experience;

    public Nurse(String dni, String fullname, Integer experience) {
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
}
