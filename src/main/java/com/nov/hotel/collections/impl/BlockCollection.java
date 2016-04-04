package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Block;
import com.nov.hotel.main.Start;

public class BlockCollection extends ObservableCollectionAbstract<Block> {

    private CrudDao<ApartType> dao = (CrudDao) Start.APPLICATION_CONTEXT.getBean("blockDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private BlockCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new BlockCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
