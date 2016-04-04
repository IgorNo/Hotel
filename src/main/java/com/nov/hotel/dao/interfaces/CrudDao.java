package com.nov.hotel.dao.interfaces;

import java.util.List;

public interface CrudDao<E> {

    //Create
    void insert(E elem);

    //Read
    E getOne(Object id);

    //Read
    List<E> getPart(Object key);

    //Read All
    List<E> getAll();

    //Update
    void update(E elem);

    //Delete
    void delete(E elem);

    //Delete
    void deleteAll();

    //Count
    int count();
}
