package com.nov.hotel.collections.interfaces;

import javafx.collections.ObservableList;

public interface ObservableCollection<E> {
    // add records
    ObservableCollection<E> add(E element);

    // update records
    ObservableCollection<E> update(E element);

    // delete records
    ObservableCollection<E> delete(E element);

    public ObservableList<E> getList();

    public ObservableCollection<E> fillData();

}
