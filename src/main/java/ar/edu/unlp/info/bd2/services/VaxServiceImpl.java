package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class VaxServiceImpl implements VaxService {
    private VaxRepository repository;

    public VaxServiceImpl(VaxRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        Patient p = new Patient(email, fullname, password, dayOfBirth);
        return (Patient) this.repository.save(p);
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine v = new Vaccine(name);
        return (Vaccine) this.repository.save(v);
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        ShotCertificate sC = new ShotCertificate(date);
        ShotCertificate shotCertificate = (ShotCertificate) this.repository.save(sC);
        Shot s = new Shot(patient, vaccine ,date ,centre , nurse, shotCertificate);
        Shot shot = (Shot) this.repository.save(s);
        patient.addShot(shot);
        return shot;
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        Optional<Patient> p =  Optional.ofNullable(
                (Patient) this.repository.getModelByProperty(new Patient(), "email", email)
        );
        return p;
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        Optional<Vaccine> v =  Optional.ofNullable(
                (Vaccine) this.repository.getModelByProperty(new Vaccine(), "name", name)
        );
        return v;
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        Centre c = new Centre(name);
        return (Centre) this.repository.save(c);
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        Nurse n = new Nurse(dni, fullName, experience);
        return (Nurse) this.repository.save(n);
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        SupportStaff s = new SupportStaff(dni, fullName, area);
        return (SupportStaff) this.repository.save(s);
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        VaccinationSchedule v = new VaccinationSchedule();
        return (VaccinationSchedule) this.repository.save(v);
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return (VaccinationSchedule) this.repository.getModelById(new VaccinationSchedule(), id);
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        Optional<Centre> c =  Optional.ofNullable(
                (Centre) this.repository.getModelByProperty(new Centre(), "name", name)
        );
        return c;
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        return staff;
    }

    @Override
    public Centre updateCentre(Centre centre) { //Qué hay q hacer acá??? El test pasa?
        return centre;
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        Optional<SupportStaff> s =  Optional.ofNullable(
                (SupportStaff) this.repository.getModelByProperty(new SupportStaff(), "dni", dni)
        );
        return s;
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return this.repository.getAllPatients();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return null;
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return null;
    }

    @Override
    public Centre getTopShotCentre() {
        return null;
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return null;
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return null;
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return null;
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return null;
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        return null;
    }
}
