package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.RecordTypesDao;
import com.antonfifindik.discographies.models.RecordTypes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class RecordTypesDaoImpl implements RecordTypesDao {

    @Autowired
    SessionFactory sessionFactory;

    public RecordTypes getById(Long id) {
        return sessionFactory.getCurrentSession().get(RecordTypes.class, id);
    }

    public void save(RecordTypes entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(RecordTypes entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<RecordTypes> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM RecordTypes").list();
    }
}
