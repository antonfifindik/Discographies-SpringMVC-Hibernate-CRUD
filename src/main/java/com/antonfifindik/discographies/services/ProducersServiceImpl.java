package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.ProducersDao;
import com.antonfifindik.discographies.interfaces.ProducersService;
import com.antonfifindik.discographies.models.Producers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class ProducersServiceImpl implements ProducersService {

    @Autowired
    ProducersDao producersDao;

    @Transactional(readOnly = true)
    public Producers getById(Long id) {
        return producersDao.getById(id);
    }

    @Transactional
    public void save(Producers entity) {
        producersDao.save(entity);
    }

    @Transactional
    public void delete(Producers entity) {
        producersDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Producers> list() {
        return producersDao.list();
    }
}
