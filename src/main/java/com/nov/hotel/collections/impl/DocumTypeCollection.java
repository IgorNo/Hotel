package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.DocumType;
import com.nov.hotel.main.Start;

public class DocumTypeCollection extends ObservableCollectionAbstract<DocumType>{

    private CrudDao<DocumType> dao = (CrudDao<DocumType>) Start.APPLICATION_CONTEXT.getBean("documTypeDao");

    private static ObservableCollectionAbstract uniqueObsColl;

    private DocumTypeCollection() {
    }

    public static ObservableCollectionAbstract getInstance() {
        if (uniqueObsColl == null){
            uniqueObsColl = new DocumTypeCollection();
        }
        return uniqueObsColl;
    }

    @Override
    protected CrudDao getDao() {
        return dao;
    }
}
