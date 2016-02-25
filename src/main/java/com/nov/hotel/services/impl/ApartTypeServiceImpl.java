package com.nov.hotel.services.impl;

import com.nov.hotel.dao.interfaces.AppartTypeDao;
import com.nov.hotel.entities.ApartType;
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
    public ApartTypeService insert(ApartType apartType) {
        try {
            appartTypeDao.insert(apartType);
        } catch (DataAccessException e) {
            return null;
        }
        return this;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public ApartType getById(int id) {
        try {
            return appartTypeDao.getById(id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public ApartType getByName(String name) {
        try {
            return appartTypeDao.getByName(name);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<ApartType> getAll(){
        try {
            return appartTypeDao.getAll();
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ApartTypeService update(ApartType apartType) {
        try {
            appartTypeDao.update(apartType);
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
