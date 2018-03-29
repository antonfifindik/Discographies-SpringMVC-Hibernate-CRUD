package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.MusiciansDao;
import com.antonfifindik.discographies.models.Musicians;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class MusiciansDaoImpl implements MusiciansDao {

    @Autowired
    SessionFactory sessionFactory;

    public Musicians getById(Long id) {
        return sessionFactory.getCurrentSession().get(Musicians.class, id);
    }

    public void save(Musicians entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Musicians entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Musicians> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Musicians").list();
    }
}
