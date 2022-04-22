package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.sql.Time;

public class Patient {
    private String email;
    private String fullname;
    private String password;
    private Time dayOfBirth;
    @Id
    private Long id;

    public Patient(String email, String fullname, String password, Time dayOfBirth) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
    }

    public Time getDayOfBirth() {
        return dayOfBirth;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }
}
