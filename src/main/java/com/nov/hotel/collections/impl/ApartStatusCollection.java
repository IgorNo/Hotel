package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.main.Start;

public class ApartStatusCollection extends ObservableCollectionAbstract<ApartStatus> {

    private CrudDao<ApartStatus> dao = (CrudDao) Start.APPLICATION_CONTEXT.getBean("apartStatusDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private ApartStatusCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new ApartStatusCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
