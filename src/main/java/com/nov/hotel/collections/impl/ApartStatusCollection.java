package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservaableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.main.Start;

public class ApartStatusCollection extends ObservaableCollectionAbstract<ApartStatus> {
    private CrudDao<ApartStatus> dao = (CrudDao<ApartStatus>) Start.APPLICATION_CONTEXT.getBean("appartStatusDao");

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
