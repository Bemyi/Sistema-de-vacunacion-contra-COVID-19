package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;

import java.sql.Time;

public class Shot {
    private Patient patient;
    private Vaccine vaccine;
    private Time dayOfBirth;
    private Centre centre;
    private Nurse nurse;
    private ShotCertificate shotCertificate;
    @Id
    private Long id;

    public Shot(Patient patient, Vaccine vaccine, Time dayOfBirth, Centre centre, Nurse nurse) {
        this.patient = patient;
        this.vaccine = vaccine;
        this.dayOfBirth = dayOfBirth;
        this.centre = centre;
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Time getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Time dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public ShotCertificate getShotCertificate() {
        return shotCertificate;
    }

    public Long getId() {
        return id;
    }
}
