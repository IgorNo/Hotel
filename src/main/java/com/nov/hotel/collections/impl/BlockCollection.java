package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservaableCollectionAbstract;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Block;
import com.nov.hotel.main.Start;

public class BlockCollection extends ObservaableCollectionAbstract<Block> {

    private CrudDao<ApartType> dao = (CrudDao<ApartType>) Start.APPLICATION_CONTEXT.getBean("blockDao");

    @Override
    protected CrudDao getDao() {
        return dao;
    }

}
