package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.util.Collection;

public class Centre {
    private String name;
    @Id
    private Long id;
    private Collection staff;

    public Centre(String name) {
        this.name = name;
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

    public Collection getStaffs() {
        return staff;
    }
}
