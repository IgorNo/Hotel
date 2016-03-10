package com.nov.hotel.services.transactions.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.services.transactions.interfaces.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AddTransaction<E> implements Transaction {

    E elem;
    CrudDao<E> dao;
    String exceptionMessage;


    public AddTransaction(CrudDao<E> dao, E elem) {
        this.elem = elem;
        this.dao = dao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void execute() {
    try {
        dao.insert(elem);
    } catch (DataAccessException e) {
        exceptionMessage = e.getLocalizedMessage();
    }
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
