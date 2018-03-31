package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.SongsDao;
import com.antonfifindik.discographies.models.Songs;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class SongsDaoImpl implements SongsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Songs getById(Long id) {
        return sessionFactory.getCurrentSession().get(Songs.class, id);
    }

    public void save(Songs entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Songs entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Songs> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Songs").list();
    }
}
