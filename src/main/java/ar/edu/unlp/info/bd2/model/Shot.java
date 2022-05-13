package ar.edu.unlp.info.bd2.model;


import javax.persistence.*;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Shot implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @JoinColumn(name = "vaccine_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Vaccine vaccine;
    private Date dateOfVaccine;
    @ManyToOne()
    @JoinColumn(name = "centre_id")
    private Centre centre;
    @ManyToOne()
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;
    @OneToOne
    private ShotCertificate shotCertificate;

    public Shot(Patient patient, Vaccine vaccine, Date dateOfVaccine, Centre centre, Nurse nurse, ShotCertificate shotCertificate) {
        this.patient = patient;
        this.vaccine = vaccine;
        this.dateOfVaccine = dateOfVaccine;
        this.centre = centre;
        this.nurse = nurse;
        this.shotCertificate = shotCertificate;
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

    public Date getDateOfVaccine() {
        return dateOfVaccine;
    }

    public void getDateOfVaccine(Date dateOfVaccine) {
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
