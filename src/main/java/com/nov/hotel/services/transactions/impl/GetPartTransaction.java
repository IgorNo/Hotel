package com.nov.hotel.services.transactions.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.services.transactions.interfaces.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GetPartTransaction<E> implements Transaction{

    List<E> eList;
    CrudDao<E> dao;
    String exceptionMessage;

    public GetPartTransaction(CrudDao<E> dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void execute() {
        try {
            eList = dao.getAll();
        } catch (DataAccessException e) {
            exceptionMessage = e.getLocalizedMessage();
        }
    }

    public List<E> geteList() {
        return eList;
    }

    @Override
    public String getExceptionMessage() {
        return null;
    }

}
