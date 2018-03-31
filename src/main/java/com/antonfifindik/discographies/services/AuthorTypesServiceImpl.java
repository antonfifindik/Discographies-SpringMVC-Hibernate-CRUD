package com.antonfifindik.discographies.services;

import com.antonfifindik.discographies.interfaces.AuthorTypesDao;
import com.antonfifindik.discographies.interfaces.AuthorTypesService;
import com.antonfifindik.discographies.models.AuthorTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
@Service
public class AuthorTypesServiceImpl implements AuthorTypesService {

    @Autowired
    private AuthorTypesDao authorTypesDao;

    @Transactional(readOnly = true)
    public AuthorTypes getById(Long id) {
        return authorTypesDao.getById(id);
    }

    @Transactional
    public void save(AuthorTypes entity) {
        authorTypesDao.save(entity);
    }

    @Transactional
    public void delete(AuthorTypes entity) {
        authorTypesDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<AuthorTypes> list() {
        return authorTypesDao.list();
    }
}
