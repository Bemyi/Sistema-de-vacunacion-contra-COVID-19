package ar.edu.unlp.info.bd2.model;


import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table
public class Centre implements Serializable, IModel{
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Personal> staff;

    public Centre(String name) {
        this.name = name;
    }

    public Centre() {

    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public void addStaff(Personal name) {
        this.staff.add(name);
    }

    public List<Personal> getStaffs() {
        return staff;
    }
}
