package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

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
        return (Patient) this.patientRepository.save(p);
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine v = new Vaccine(name);
        return (Vaccine) this.vaccineRepository.save(v);
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        return null;
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        Optional<Patient> p =  Optional.ofNullable(
                (Patient) this.patientRepository.findByEmail(email)
        );
        return p;
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return Optional.ofNullable(this.vaccineRepository.findByName(name));
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        return null;
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        return null;
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return null;
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        return Optional.empty();
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        return null;
    }

    @Override
    public Centre updateCentre(Centre centre) {
        return null;
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return Optional.empty();
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
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
