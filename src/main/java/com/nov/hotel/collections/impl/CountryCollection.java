package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.impl.CountryDaoImpl;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Country;
import com.nov.hotel.main.Start;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryCollection extends ObservableCollectionAbstract<String, Country> {


    private CountryDaoImpl dao = (CountryDaoImpl) Start.APPLICATION_CONTEXT.getBean("countryDao");

    private static CountryCollection uniqueObsColl;

    private CountryCollection() {
    }

    public static CountryCollection getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new CountryCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
