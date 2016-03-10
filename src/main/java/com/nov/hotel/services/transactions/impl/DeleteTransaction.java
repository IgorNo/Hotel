package com.nov.hotel.services.transactions.impl;

import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.services.transactions.interfaces.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DeleteTransaction<E> implements Transaction{

    E elem;
    CrudDao<E> dao;
    String exceptionMessage;

    public DeleteTransaction(CrudDao<E> dao, E elem) {
        this.elem = elem;
        this.dao = dao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void execute() {
    try {
        dao.delete(elem);
    } catch (DataAccessException e) {
        exceptionMessage = e.getLocalizedMessage();
    }
    }

    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
