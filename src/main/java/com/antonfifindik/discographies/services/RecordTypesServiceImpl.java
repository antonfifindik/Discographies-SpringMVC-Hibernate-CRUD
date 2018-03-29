package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.RecordTypesDao;
import com.antonfifindik.discographies.interfaces.RecordTypesService;
import com.antonfifindik.discographies.models.RecordTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class RecordTypesServiceImpl implements RecordTypesService {

    @Autowired
    RecordTypesDao recordTypesDao;

    @Transactional(readOnly = true)
    public RecordTypes getById(Long id) {
        return recordTypesDao.getById(id);
    }

    @Transactional
    public void save(RecordTypes entity) {
        recordTypesDao.save(entity);
    }

    @Transactional
    public void delete(RecordTypes entity) {
        recordTypesDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<RecordTypes> list() {
        return recordTypesDao.list();
    }
}
