package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.main.Start;

public class ApartmentCollection extends ObservableCollectionAbstract<Apartment> {

    private CrudDao<Apartment> dao = (CrudDao<Apartment>) Start.APPLICATION_CONTEXT.getBean("appartmentDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private ApartmentCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new ApartmentCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}