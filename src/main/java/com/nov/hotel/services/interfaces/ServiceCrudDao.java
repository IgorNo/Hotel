package com.nov.hotel.services.interfaces;

import java.util.List;

public interface ServiceCrudDao<E> {

    //Create
    ServiceCrudDao<E> insert(E elem);

    //Read
    E getById(int id);

    //Read
    List<E> getByName(String name);

    //Read All
    List<E> getAll();

    //Update
    ServiceCrudDao<E> update(E elem);

    //Delete
    ServiceCrudDao<E> delete(E elem);

    //Count
    int count();

}
