package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservaableCollectionAbstract;
import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.main.Start;
import com.nov.hotel.services.transactions.impl.AddTransaction;
import com.nov.hotel.services.transactions.impl.GetAllTransaction;
import com.nov.hotel.services.transactions.impl.UpdateTransaction;
import com.nov.hotel.services.transactions.utils.TransactionsEngine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ApartTypeCollection extends ObservaableCollectionAbstract<ApartType> {

    private CrudDao<ApartType> dao = (CrudDao<ApartType>) Start.APPLICATION_CONTEXT.getBean("appartTypeDao");

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
