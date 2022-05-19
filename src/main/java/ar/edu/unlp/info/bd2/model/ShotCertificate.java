package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table
public class ShotCertificate implements Serializable, IModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Integer serialNumber;

    public ShotCertificate(Date date) {
        this.date = date;
        this.serialNumber = (int) (Math.random()*1000+1);
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
