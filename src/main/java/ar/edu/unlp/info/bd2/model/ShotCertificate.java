package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table
public class ShotCertificate implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private Integer serialNumber;

    public ShotCertificate(Date date) {
        this.date = date;
        this.serialNumber = 0; // Crear un random
    }

    public ShotCertificate() {

    }

    public Date getDate() {
        return date;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }
}
