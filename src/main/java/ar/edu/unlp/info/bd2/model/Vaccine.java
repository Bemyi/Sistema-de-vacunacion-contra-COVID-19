package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.sql.Time;

public class Vaccine {
    private Time name;
    @Id
    private Long id;

    public Vaccine(Time name) {
        this.name = name;
    }

    public Time getName() {
        return name;
    }

    public void setName(Time name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
