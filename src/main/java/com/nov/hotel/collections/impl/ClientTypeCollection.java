package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ClientType;
import com.nov.hotel.main.Start;

public class ClientTypeCollection extends ObservableCollectionAbstract<ClientType>{

    private CrudDao<ClientType> dao = (CrudDao) Start.APPLICATION_CONTEXT.getBean("clientTypeDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private ClientTypeCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new ClientTypeCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
