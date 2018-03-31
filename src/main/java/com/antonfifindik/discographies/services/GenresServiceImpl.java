package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.dao.DaoException;
import com.antonfifindik.discographies.interfaces.GenresDao;
import com.antonfifindik.discographies.interfaces.GenresService;
import com.antonfifindik.discographies.models.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresDao genresDao;

    @Transactional(readOnly = true)
    public Genres getById(Long id) {
        return genresDao.getById(id);
    }

    @Transactional
    public void save(Genres entity) {
        genresDao.save(entity);
    }

    @Transactional
    public void delete(Genres entity) {
        genresDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Genres> list() {
        return genresDao.list();
    }
}
