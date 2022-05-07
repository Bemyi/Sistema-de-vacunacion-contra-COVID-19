package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.IModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Object save(IModel modelObj) throws VaxException {

        try {
            Session session = sessionFactory.getCurrentSession();
            Long id = (Long) session.save(modelObj);
            Object objPersisted = session.find(modelObj.getClass(), id);
            session.getTransaction().commit();
            return objPersisted;
        }
        catch(Exception ex) {
            throw new VaxException("Constraint Violation");
        }
    }

    public IModel getModelByProperty(IModel m, String propertyName, Object property) {
        Session session = sessionFactory.getCurrentSession();
        IModel model = (IModel) session.byNaturalId(m.getClass()).using(propertyName, property).load();
        return model;
    }
}
