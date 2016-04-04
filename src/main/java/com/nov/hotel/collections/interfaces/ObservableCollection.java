package com.nov.hotel.collections.interfaces;

import com.nov.hotel.services.transactions.utils.TransactionsEngine;
import javafx.collections.ObservableList;

public interface ObservableCollection<E> {
    // add records
    ObservableCollection add(E element);

    // update records
    ObservableCollection update(E element);

    // delete records
    ObservableCollection delete(E element);

    ObservableList<E> getList();

    TransactionsEngine getTransactionsEngine();

    ObservableCollection fillData();

    <K> ObservableCollection fillData(K key);
}
