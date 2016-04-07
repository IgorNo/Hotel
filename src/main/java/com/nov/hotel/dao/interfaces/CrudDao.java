package com.nov.hotel.dao.interfaces;

import com.nov.hotel.entities.interfaces.Entity;

import java.util.List;

public interface CrudDao<K, V> {

    //Create
    void insert(V elem);

    //Read
    V getSingle(K id);

    //Read
    List<V> getSelected(Object sample);

    //Read All
    List<V> getAll();

    //Update
    void update(V elem);

    //Delete
    void delete(V elem);

    //Delete
    void deleteAll();

    //Count
    int count();
}
