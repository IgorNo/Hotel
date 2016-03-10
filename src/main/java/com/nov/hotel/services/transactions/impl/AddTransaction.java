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


    public AddTransaction(E elem, CrudDao<E> dao) {
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

    public void setDao(CrudDao<E> dao) {
        this.dao = dao;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
