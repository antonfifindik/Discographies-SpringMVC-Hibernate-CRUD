package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.ProducersDao;
import com.antonfifindik.discographies.models.Producers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class ProducersDaoImpl implements ProducersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Producers getById(Long id) {
        return sessionFactory.getCurrentSession().get(Producers.class, id);
    }

    public void save(Producers entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Producers entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Producers> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Producers").list();
    }
}
