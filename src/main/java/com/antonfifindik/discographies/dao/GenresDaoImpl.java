package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.GenresDao;
import com.antonfifindik.discographies.models.Genres;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class GenresDaoImpl implements GenresDao {

    @Autowired
    SessionFactory sessionFactory;

    public Genres getById(Long id) {
        return sessionFactory.getCurrentSession().get(Genres.class, id);
    }

    public void save(Genres entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Genres entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Genres> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Genres").list();
    }
}
