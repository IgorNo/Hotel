package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.impl.ApartmentDaoImpl;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Apartment;
import com.nov.hotel.main.Start;
import org.springframework.beans.factory.annotation.Autowired;

import static com.nov.hotel.main.Start.APPLICATION_CONTEXT;

public class ApartmentCollection extends ObservableCollectionAbstract<Long, Apartment> {

    private ApartmentDaoImpl dao = (ApartmentDaoImpl) APPLICATION_CONTEXT.getBean("apartmentDao");

    private static ApartmentCollection uniqueObsColl;

    private ApartmentCollection() {
    }

    public static ApartmentCollection getInstance() {
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
