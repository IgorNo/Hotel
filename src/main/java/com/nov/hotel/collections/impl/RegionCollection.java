package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.Region;
import com.nov.hotel.main.Start;

public class RegionCollection extends ObservableCollectionAbstract<Region> {

    private CrudDao<Region> dao = (CrudDao) Start.APPLICATION_CONTEXT.getBean("regionDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private RegionCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new RegionCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
