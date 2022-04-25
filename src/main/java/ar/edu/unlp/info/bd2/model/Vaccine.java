package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table
public class Vaccine implements Serializable {

    @Column
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
}
