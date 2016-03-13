package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservaableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.main.Start;

public class ApartmentCollection extends ObservaableCollectionAbstract<Apartment> {

    private CrudDao<Apartment> dao = (CrudDao<Apartment>) Start.APPLICATION_CONTEXT.getBean("appartmentDao");

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
