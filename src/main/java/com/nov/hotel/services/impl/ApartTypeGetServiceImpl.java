package com.nov.hotel.services.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("appartTypeService")
public class ApartTypeGetServiceImpl extends GetServiceAbstract<ApartType> {

    private CrudDao<ApartType> appartTypeDao;

    @Resource(name = "appartTypeDao")
    public void setAppartTypeDao(CrudDao<ApartType> appartTypeDao) {
        this.appartTypeDao = appartTypeDao;
    }

    @Override
    CrudDao<ApartType> getDao() {
        return appartTypeDao;
    }
}
