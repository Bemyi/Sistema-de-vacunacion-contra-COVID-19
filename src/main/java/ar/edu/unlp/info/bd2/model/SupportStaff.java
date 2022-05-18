package ar.edu.unlp.info.bd2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class SupportStaff extends Staff {
    private String area;

    public SupportStaff(String dni, String fullname, String area) {
        super(fullname, dni);
        this.area = area;
    }

    public SupportStaff() {
        super();
    }

    public String getArea() {
        return area;
    }
}
