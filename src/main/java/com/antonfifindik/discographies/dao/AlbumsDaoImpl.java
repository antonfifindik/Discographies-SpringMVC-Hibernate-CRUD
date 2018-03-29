package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.AlbumsDao;
import com.antonfifindik.discographies.models.Albums;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class AlbumsDaoImpl implements AlbumsDao {

    @Autowired
    SessionFactory sessionFactory;

    public Albums getById(Long id) {
        return sessionFactory.getCurrentSession().get(Albums.class, id);
    }

    public void save(Albums entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Albums entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Albums> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Albums").list();
    }
}
