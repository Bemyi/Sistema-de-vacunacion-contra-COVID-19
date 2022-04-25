package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Collection;
import java.util.Date;

public class Patient {
    private String email;
    private String fullname;
    private String password;
    private Date dayOfBirth;
    private Collection shots;

    private Long id;

    public Patient(String email, String fullname, String password, Date dayOfBirth) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    // Conectar con las vacunas
    public Collection getShots() {
        return shots;
    }
}
