package com.antonfifindik.discographies.interfaces;

import com.antonfifindik.discographies.dao.DaoException;
import com.antonfifindik.discographies.models.BaseEntity;

import java.util.List;

/**
 * Created by Антон on 29.03.2018.
 */
public interface BaseDao<T extends BaseEntity> {
    T getById(Long id);

    void save(T entity);

    void delete(T entity);

    List<T> list();
}
