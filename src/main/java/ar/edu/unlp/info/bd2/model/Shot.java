package ar.edu.unlp.info.bd2.model;


import javax.persistence.*;
import javax.persistence.GenerationType;
import java.sql.Time;
import java.io.Serializable;
@Entity
@Table
public class Shot implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Patient patient;
    private Vaccine vaccine;
    private Time dateOfVaccine;
    private Centre centre;
    private Nurse nurse;
    private ShotCertificate shotCertificate;

    public Shot(Patient patient, Vaccine vaccine, Time dateOfVaccine, Centre centre, Nurse nurse) {
        this.patient = patient;
        this.vaccine = vaccine;
        this.dateOfVaccine = dateOfVaccine;
        this.centre = centre;
        this.nurse = nurse;
        this.shotCertificate = new ShotCertificate(dateOfVaccine);
    }

    public Shot() {

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

    public Time getDateOfVaccine() {
        return dateOfVaccine;
    }

    public void getDateOfVaccine(Time dateOfVaccine) {
        this.dateOfVaccine = dateOfVaccine;
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
