package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.AlbumTypesDao;
import com.antonfifindik.discographies.interfaces.AlbumTypesService;
import com.antonfifindik.discographies.models.AlbumTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class AlbumTypesServiceImpl implements AlbumTypesService {

    @Autowired
    AlbumTypesDao albumTypesDao;

    @Transactional(readOnly = true)
    public AlbumTypes getById(Long id) {
        return albumTypesDao.getById(id);
    }

    @Transactional
    public void save(AlbumTypes entity) {
        albumTypesDao.save(entity);
    }

    @Transactional
    public void delete(AlbumTypes entity) {
        albumTypesDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<AlbumTypes> list() {
        return albumTypesDao.list();
    }
}
