package com.nov.hotel.collections.abstr;

import com.nov.hotel.collections.interfaces.ObservaableCollection;
import com.nov.hotel.dao.interfaces.CrudDao;
import com.nov.hotel.entities.interfaces.Entity;
import com.nov.hotel.services.transactions.impl.AddTransaction;
import com.nov.hotel.services.transactions.impl.GetAllTransaction;
import com.nov.hotel.services.transactions.impl.UpdateTransaction;
import com.nov.hotel.services.transactions.utils.TransactionsEngine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

abstract public class ObservaableCollectionAbstract<E extends Entity> implements ObservaableCollection<E> {

    private ObservableList<E> list = FXCollections.observableArrayList();

    private TransactionsEngine transactionsEngine = new TransactionsEngine();

    // Factory Method
    protected abstract CrudDao getDao();

    @Override
    public ObservaableCollection<E> add(E element) {
        if (!element.validate()){
            return null;
        }
        transactionsEngine.addTransaction(new AddTransaction<>(getDao(),element));
        list.add(element);
        return this;
    }


    @Override
    public ObservaableCollection<E> update(E element) {
        if (!element.validate()){
            return null;
        }
        transactionsEngine.addTransaction(new UpdateTransaction<>(getDao(),element));
        return this;
    }

    @Override
    public ObservaableCollection<E> delete(E element) {
        if (!element.validate()){
            return null;
        }
        transactionsEngine.addTransaction(new UpdateTransaction<>(getDao(),element));
        list.remove(element);
        return this;
    }

    @Override
    public ObservableList<E> getList() {
        return list;
    }

    public TransactionsEngine getTransactionsEngine() {
        return transactionsEngine;
    }

    @Override
    public void fillData() {
        GetAllTransaction<E> t = new GetAllTransaction(getDao());
        t.execute();
        list.addAll(t.geteList());
    }
}
