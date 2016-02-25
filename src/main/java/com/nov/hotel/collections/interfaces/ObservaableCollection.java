package com.nov.hotel.collections.interfaces;

import javafx.collections.ObservableList;

public interface ObservaableCollection<E> {
    // add records
    ObservaableCollection<E> add(E element);

    // update records
    ObservaableCollection<E> update(E element);

    // delete records
    ObservaableCollection<E> delete(E element);

    public ObservableList<E> getList();

    public void fillData();


}
