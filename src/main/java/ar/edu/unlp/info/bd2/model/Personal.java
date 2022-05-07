package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table
public class Personal implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String dni;
    @OneToMany
    private List<Centre> centres;

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

    //Conectar con los centros
    public List<Centre> getCentres() {
        return centres;
    }
}
