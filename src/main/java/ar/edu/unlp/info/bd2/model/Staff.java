package ar.edu.unlp.info.bd2.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personal_type", discriminatorType = DiscriminatorType.INTEGER)
public class Staff implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @NaturalId
    private String dni;

    @ManyToMany (mappedBy = "staff")
    private List<Centre> centres = new ArrayList<>();

    public Staff(String fullName, String dni) {
        this.fullName = fullName;
        this.dni = dni;
    }

    public Staff() {

    }

    public String getFullName() {
        return fullName;
    }

    public String getDni() {
        return dni;
    }

    public Long getId() {
        return id;
    }

    public List<Centre> getCentres() {
        return centres;
    }
}
