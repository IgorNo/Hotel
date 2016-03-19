package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.main.Start;


public class ApartTypeCollection extends ObservableCollectionAbstract<ApartType> {

    private CrudDao<ApartType> dao = (CrudDao<ApartType>) Start.APPLICATION_CONTEXT.getBean("apartTypeDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private ApartTypeCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new ApartTypeCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
