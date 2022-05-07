package ar.edu.unlp.info.bd2.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Vaccine implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    @Column(unique = true)
    private String name;

    public Vaccine(String name) {
        this.name = name;
    }

    public Vaccine() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
