package ar.edu.unlp.info.bd2.model;

public class Nurse extends Personal {
    private Integer experience;

    public Nurse(String fullname, String dni, Integer experience) {
        super(fullname, dni);
        this.experience = experience;
    }

    public Integer getExperience() {
        return experience;
    }
}
