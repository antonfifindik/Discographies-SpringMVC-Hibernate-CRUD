package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.AlbumTypesDao;
import com.antonfifindik.discographies.models.AlbumTypes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class AlbumTypesDaoImpl implements AlbumTypesDao {

    @Autowired
    SessionFactory sessionFactory;

    public AlbumTypes getById(Long id) {
        return sessionFactory.getCurrentSession().get(AlbumTypes.class, id);
    }

    public void save(AlbumTypes entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(AlbumTypes entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<AlbumTypes> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM AlbumTypes").list();
    }
}
