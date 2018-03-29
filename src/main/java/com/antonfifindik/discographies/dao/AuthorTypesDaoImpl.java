package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.AuthorTypesDao;
import com.antonfifindik.discographies.models.AuthorTypes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class AuthorTypesDaoImpl implements AuthorTypesDao {

    @Autowired
    SessionFactory sessionFactory;

    public AuthorTypes getById(Long id) {
        return sessionFactory.getCurrentSession().get(AuthorTypes.class, id);
    }

    public void save(AuthorTypes entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(AuthorTypes entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<AuthorTypes> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM AuthorTypes").list();
    }
}
