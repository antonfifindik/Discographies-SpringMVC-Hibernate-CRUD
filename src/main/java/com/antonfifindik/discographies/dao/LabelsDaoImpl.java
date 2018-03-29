package com.antonfifindik.discographies.dao;

import com.antonfifindik.discographies.interfaces.LabelsDao;
import com.antonfifindik.discographies.models.Labels;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Repository
public class LabelsDaoImpl implements LabelsDao {

    @Autowired
    SessionFactory sessionFactory;

    public Labels getById(Long id) {
        return sessionFactory.getCurrentSession().get(Labels.class, id);
    }

    public void save(Labels entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(Labels entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Labels> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Labels").list();
    }
}
