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
    @Column(unique = true)
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
    private List<Staff> staff = new ArrayList<>();

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

    public void addStaff(Staff staff) {
        this.staff.add(staff);
        staff.getCentres().add(this);
    }

    public void removeStaff(Staff staff) {
        this.staff.remove(staff);
        staff.getCentres().remove(this);
    }

    public List<Staff> getStaffs() {
        return staff;
    }
}
