package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.IModel;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;
@Transactional
public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Object save(IModel modelObj) throws VaxException {
        try {
            Long id = (Long) sessionFactory.getCurrentSession().save(modelObj);
            return sessionFactory.getCurrentSession().find(modelObj.getClass(), id);
        }
        catch(Exception ex) {
            throw new VaxException("Constraint Violation");
        }
    }

    public IModel getModelByProperty(IModel m, String propertyName, Object property) {
        Session session = sessionFactory.getCurrentSession();
        IModel model = session.byNaturalId(m.getClass()).using(propertyName, property).load();
        return model;
    }

    public IModel getModelById(IModel m, Long id) {
        Session session = sessionFactory.getCurrentSession();
        IModel model = session.get(m.getClass(), id);
        return model;
    }

    public List<Patient> getAllPatients() {
        Session session = sessionFactory.getCurrentSession();
        List patientsList = session.createQuery("select p from Patient as p").list();
        return patientsList;
    }

    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        Session session = sessionFactory.getCurrentSession();
        List nursesList = session.createQuery("select n " +
                "from Nurse " +
                "as n " +
                "where n.experience > :years")
                .setParameter("years", years)
                .list();
        return nursesList;
    }

    public Centre getTopShotCentre(){
        Session session = sessionFactory.getCurrentSession();
        List centres = session.createQuery("select new Centre (s.centre.name)" +
                "from Shot as s "+
                "group by s.centre "+
                "order by count(s.centre.id) desc").list();
        Centre centre = (Centre) centres.get(0);
        return centre;
    }

    public List<Nurse> getNurseNotShot(){
        Session session = sessionFactory.getCurrentSession();
        List nurses = session.createQuery("select n " +
                "from Nurse as n "+
                "where n.id not in(select s.nurse.id from Shot as s)").list();
        return nurses;
    }
}
