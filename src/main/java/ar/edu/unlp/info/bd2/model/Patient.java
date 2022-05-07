package ar.edu.unlp.info.bd2.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
@Entity
@Table
public class Patient implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    @Column(unique = true)
    private String email;
    private String fullname;
    private String password;

    private Date dayOfBirth;
    @OneToMany
    private List<Shot> shots;


    public Patient(String email, String fullname, String password, Date dayOfBirth) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        System.out.println(dayOfBirth);
        System.out.println(this.dayOfBirth);
    }

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public Date getDayOfBirth() {
        return this.dayOfBirth;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    // Conectar con las vacunas
    public List<Shot> getShots() {
        return shots;
    }
}
