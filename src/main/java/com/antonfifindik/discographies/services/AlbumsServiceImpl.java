package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.AlbumsDao;
import com.antonfifindik.discographies.interfaces.AlbumsService;
import com.antonfifindik.discographies.models.Albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class AlbumsServiceImpl implements AlbumsService {

    @Autowired
    private AlbumsDao albumsDao;

    @Transactional(readOnly = true)
    public Albums getById(Long id) {
        return albumsDao.getById(id);
    }

    @Transactional
    public void save(Albums entity) {
        albumsDao.save(entity);
    }

    @Transactional
    public void delete(Albums entity) {
        albumsDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Albums> list() {
        return albumsDao.list();
    }
}
