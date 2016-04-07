package com.nov.hotel.collections.impl;

import com.nov.hotel.collections.abstr.ObservableCollectionAbstract;
import com.nov.hotel.dao.impl.BlockDaoImpl;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Block;
import com.nov.hotel.main.Start;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockCollection extends ObservableCollectionAbstract<Integer, Block> {

    private BlockDaoImpl dao = (BlockDaoImpl) Start.APPLICATION_CONTEXT.getBean("blockDao");

    private static BlockCollection uniqueObsColl;

    private BlockCollection() {
    }

    public static BlockCollection getInstance() {
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
