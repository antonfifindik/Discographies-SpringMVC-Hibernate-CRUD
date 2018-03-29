package com.antonfifindik.discographies.interfaces;

import com.antonfifindik.discographies.dao.DaoException;
import com.antonfifindik.discographies.models.BaseEntity;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
public interface IDao<T extends BaseEntity> {
    T getById(Long id) throws DaoException;

    void save(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    List<T> list() throws DaoException;
}
