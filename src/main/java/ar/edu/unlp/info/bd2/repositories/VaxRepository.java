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
            session.getTransaction().begin(); // ¿? Si no hay esto dice q la transacción no se inicia y solamente persiste el primer objeto. Problemas con el commit de arriba
            return objPersisted;
        }
        catch(Exception ex) {
            //throw new VaxException("Constraint Violation");
            throw new VaxException(ex.getMessage());
        }
    }

    public IModel getModelByProperty(IModel m, String propertyName, Object property) {
        Session session = sessionFactory.getCurrentSession();
        IModel model = (IModel) session.byNaturalId(m.getClass()).using(propertyName, property).load();
        return model;
    }

    public IModel getModelByPropertys(IModel m, String propertyName, Object property) {
        Session session = sessionFactory.getCurrentSession();
        IModel model = (IModel) session.bySimpleNaturalId(m.getClass()).load(property);
        return model;
    }
}
