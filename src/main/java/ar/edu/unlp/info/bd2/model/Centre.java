package ar.edu.unlp.info.bd2.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Centre implements Serializable, IModel{
    @NaturalId
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "centre_personal",
            joinColumns = {@JoinColumn(name = "centre_id")},
            inverseJoinColumns = {@JoinColumn(name = "personal_id")}
    )
    private List<Personal> staff = new ArrayList<>();

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

    public void addStaff(Personal personal) {
        this.staff.add(personal);
        personal.getCentres().add(this);
    }

    public void removeStaff(Personal personal) {
        this.staff.remove(personal);
        personal.getCentres().remove(this);
    }

    public List<Personal> getStaffs() {
        return staff;
    }
}
