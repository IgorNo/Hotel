package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Country;
import com.nov.hotel.main.Start;

public class CountryCollection extends ObservableCollectionAbstract<Country>{

    private CrudDao<Country> dao = (CrudDao<Country>) Start.APPLICATION_CONTEXT.getBean("countryDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private CountryCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
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
