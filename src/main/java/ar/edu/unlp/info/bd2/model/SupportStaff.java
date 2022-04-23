package ar.edu.unlp.info.bd2.model;

public class SupportStaff extends Personal{
    private String area;

    public SupportStaff(String fullname, Integer dni, String area) {
        super(fullname, dni);
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
