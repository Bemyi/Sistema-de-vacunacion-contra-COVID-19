package ar.edu.unlp.info.bd2.model;

public class Personal {
    private String fullname;
    private Integer dni;

    public Personal(String fullname, Integer dni) {
        this.fullname = fullname;
        this.dni = dni;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getDni() {
        return dni;
    }
}
