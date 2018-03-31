package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.AuthorsDao;
import com.antonfifindik.discographies.models.Authors;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class AuthorsDaoImpl implements AuthorsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Authors getById(Long id) {
        return sessionFactory.getCurrentSession().get(Authors.class, id);
    }

    public void save(Authors entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Authors entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Authors> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Authors").list();
    }
}
