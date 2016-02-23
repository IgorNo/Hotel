package com.nov.hotel.services.impl;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.entities.AppartType;
import com.nov.hotel.services.interfaces.ApartTypeService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("appartTypeService")
public class ApartTypeServiceImpl implements ApartTypeService {

    private AppartTypeDao appartTypeDao;

    @Resource(name = "appartTypeDao")
    public void setAppartTypeDao(AppartTypeDao appartTypeDao) {
        this.appartTypeDao = appartTypeDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ApartTypeService insert(AppartType appartType) {
        try {
            appartTypeDao.insert(appartType);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public AppartType getById(int id) {
        try {
            return appartTypeDao.getById(id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public AppartType getByName(String name) {
        try {
            return appartTypeDao.getByName(name);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<AppartType> getAll(){
        try {
            return appartTypeDao.getAll();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ApartTypeService update(AppartType appartType) {
        try {
            appartTypeDao.update(appartType);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public ApartTypeService delete(int id) {
        try {
            appartTypeDao.delete(id);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public int count() {
        return appartTypeDao.count();
    }

}
