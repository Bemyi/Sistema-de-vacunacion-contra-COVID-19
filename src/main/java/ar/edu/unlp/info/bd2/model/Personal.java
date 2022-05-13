package ar.edu.unlp.info.bd2.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personal_type", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorFormula("case when color is not null then 1 else 2 end")
public class Personal implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @NaturalId
    private String dni;
    //@OneToMany
    //private List<Centre> centres;

    @ManyToMany
    private List<Centre> centres = new ArrayList<>();

    public Personal(String fullName, String dni) {
        this.fullName = fullName;
        this.dni = dni;
    }

    public Personal() {

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

    //Conectar con los centros
    public List<Centre> getCentres() {
        return centres;
    }
}
