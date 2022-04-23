package ar.edu.unlp.info.bd2.model;

import java.util.Date;

public class ShotCertificate {
    private Date date;
    private Integer serialNumber;

    public ShotCertificate(Date date) {
        this.date = date;
        this.serialNumber = 0; // Crear un random
    }

    public Date getDate() {
        return date;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }
}
