package com.nov.hotel.collections.interfaces;

import javafx.collections.ObservableList;

public interface ObservaableCollection<T> {
    // добавить запись
    ObservaableCollection<T> add(T element);

    // внести измененные значения (подтвердить измененные данные)
    ObservaableCollection<T> update(T element);

    // удалить запись
    ObservaableCollection<T> delete(T element);

    public ObservableList<T> getList();

}
