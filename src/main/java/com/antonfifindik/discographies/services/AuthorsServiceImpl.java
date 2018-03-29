package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.AuthorsDao;
import com.antonfifindik.discographies.interfaces.AuthorsService;
import com.antonfifindik.discographies.models.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    AuthorsDao authorsDao;

    @Transactional(readOnly = true)
    public Authors getById(Long id) {
        return authorsDao.getById(id);
    }

    @Transactional
    public void save(Authors entity) {
        authorsDao.save(entity);
    }

    @Transactional
    public void delete(Authors entity) {
        authorsDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Authors> list() {
        return authorsDao.list();
    }
}
