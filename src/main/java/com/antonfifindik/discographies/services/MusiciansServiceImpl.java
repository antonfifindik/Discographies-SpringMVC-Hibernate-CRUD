package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.MusiciansDao;
import com.antonfifindik.discographies.interfaces.MusiciansService;
import com.antonfifindik.discographies.models.Musicians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class MusiciansServiceImpl implements MusiciansService {

    @Autowired
    private MusiciansDao musiciansDao;

    @Transactional(readOnly = true)
    public Musicians getById(Long id) {
        return musiciansDao.getById(id);
    }

    @Transactional
    public void save(Musicians entity) {
        musiciansDao.save(entity);
    }

    @Transactional
    public void delete(Musicians entity) {
        musiciansDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Musicians> list() {
        return musiciansDao.list();
    }
}
