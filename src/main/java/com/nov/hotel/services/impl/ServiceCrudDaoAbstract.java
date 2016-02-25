package com.nov.hotel.services.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.services.interfaces.ServiceCrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

abstract class ServiceCrudDaoAbstract<E> implements ServiceCrudDao<E>{

    abstract CrudDao<E> getDao();

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ServiceCrudDao<E> insert(E elem) {
        try {
            getDao().insert(elem);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public E getById(int id) {
        try {
            return getDao().getById(id);
        } catch (DataAccessException e) {
            return null;
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public List<E> getByName(String name) {
        try {
            return getDao().getByName(name);
        } catch (DataAccessException e) {
            return null;
        }
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public List<E> getAll() {
        try {
            return getDao().getAll();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ServiceCrudDao<E> update(E elem) {
        try {
            getDao().update(elem);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public ServiceCrudDao<E> delete(E elem) {
        try {
            getDao().delete(elem);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public int count() {
        return getDao().count();
    }
}
