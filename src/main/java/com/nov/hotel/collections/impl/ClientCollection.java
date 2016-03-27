package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Client;
import com.nov.hotel.main.Start;

public class ClientCollection extends ObservableCollectionAbstract<Client>{

    private CrudDao<ApartType> dao = (CrudDao<ApartType>) Start.APPLICATION_CONTEXT.getBean("clientDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private ClientCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new ClientCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
