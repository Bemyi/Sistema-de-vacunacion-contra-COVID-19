package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SpringDataVaxService implements VaxService {
    @Autowired
    private CentreRepository centreRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ShotCertificateRepository shotCertificateRepository;

    @Autowired
    private ShotRepository shotRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private SupportStaffRepository supportStaffRepository;

    @Autowired
    private VaccinationScheduleRepository vaccinationScheduleRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        Patient p = new Patient(email, fullname, password, dayOfBirth);
        try {
            return this.patientRepository.save(p);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine v = new Vaccine(name);
        try{
            return this.vaccineRepository.save(v);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        try{
            ShotCertificate sC = new ShotCertificate(date);
            ShotCertificate shotCertificate = this.shotCertificateRepository.save(sC);
            Shot s = new Shot(patient, vaccine ,date ,centre , nurse, shotCertificate);
            Shot shot = this.shotRepository.save(s);
            patient.addShot(shot);
            return shot;
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        Optional<Patient> p =  Optional.ofNullable(
                this.patientRepository.findByEmail(email)
        );
        return p;
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return Optional.ofNullable(this.vaccineRepository.findByName(name));
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        Centre c = new Centre(name);
        try{
            return this.centreRepository.save(c);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        Nurse n = new Nurse(dni, fullName, experience);
        try {
            return this.nurseRepository.save(n);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        SupportStaff s = new SupportStaff(dni, fullName, area);
        try {
            return this.supportStaffRepository.save(s);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        VaccinationSchedule v = new VaccinationSchedule();
        try {
            return this.vaccinationScheduleRepository.save(v);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        try {
            return this.vaccinationScheduleRepository.findById(id).get();
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        try {
            return Optional.ofNullable(this.centreRepository.findByName(name));
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        try {
            return this.supportStaffRepository.save(staff);
        }
        catch (Exception e){
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Centre updateCentre(Centre centre) {
        return this.centreRepository.save(centre);
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        Optional<SupportStaff> s =  Optional.ofNullable(
                this.supportStaffRepository.findByDni(dni)
        );
        return s;
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
        return this.vaccinationScheduleRepository.save(schedule);
    }

    @Override
    public List<Patient> getAllPatients() {
        return (List<Patient>) this.patientRepository.findAll();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return this.nurseRepository.findByExperienceGreaterThan(years);
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {

        return centreRepository.getCentresTopNStaff(PageRequest.of(0, 5));
    }

    @Override
    public Centre getTopShotCentre() {
        return this.centreRepository.getTopShotCentre().get(0);
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return this.nurseRepository.getNurseNotShot();
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return (String) this.supportStaffRepository.getLessEmployeesSupportStaffArea(PageRequest.of(0, 1)).get(0);
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return this.staffRepository.getAllByFullNameContaining(name);
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return this.vaccineRepository.getUnappliedVaccines();
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        return this.shotCertificateRepository.findByDateBetween(startDate, endDate);
    }
}
