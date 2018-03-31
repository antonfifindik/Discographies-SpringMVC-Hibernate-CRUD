package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.SongsDao;
import com.antonfifindik.discographies.interfaces.SongsService;
import com.antonfifindik.discographies.models.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class SongsServiceImpl implements SongsService {

    @Autowired
    private SongsDao songsDao;

    @Transactional(readOnly = true)
    public Songs getById(Long id) {
        return songsDao.getById(id);
    }

    @Transactional
    public void save(Songs entity) {
        songsDao.save(entity);
    }

    @Transactional
    public void delete(Songs entity) {
        songsDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Songs> list() {
        return songsDao.list();
    }
}
