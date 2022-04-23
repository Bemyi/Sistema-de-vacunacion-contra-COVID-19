package ar.edu.unlp.info.bd2.model;

import java.util.Collection;

public class Personal {
    private String fullName;
    private String dni;
    private Collection centres;

    public Personal(String fullName, String dni) {
        this.fullName = fullName;
        this.dni = dni;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDni() {
        return dni;
    }

    //Conectar con los centros
    public Collection getCentres() {
        return centres;
    }
}
