package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.LabelsDao;
import com.antonfifindik.discographies.interfaces.LabelsService;
import com.antonfifindik.discographies.models.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class LabelsServiceImpl implements LabelsService {

    @Autowired
    LabelsDao labelsDao;

    @Transactional(readOnly = true)
    public Labels getById(Long id) {
        return labelsDao.getById(id);
    }

    @Transactional
    public void save(Labels entity) {
        labelsDao.save(entity);
    }

    @Transactional
    public void delete(Labels entity) {
        labelsDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Labels> list() {
        return labelsDao.list();
    }
}
