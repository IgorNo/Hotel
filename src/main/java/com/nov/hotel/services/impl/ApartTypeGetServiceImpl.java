package com.nov.hotel.services.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("apartTypeService")
public class ApartTypeGetServiceImpl extends GetServiceAbstract<ApartType> {

    private CrudDao<ApartType> apartTypeDao;

    @Resource(name = "apartTypeDao")
    public void setApartTypeDao(CrudDao<ApartType> apartTypeDao) {
        this.apartTypeDao = apartTypeDao;
    }

    @Override
    CrudDao<ApartType> getDao() {
        return apartTypeDao;
    }
}
