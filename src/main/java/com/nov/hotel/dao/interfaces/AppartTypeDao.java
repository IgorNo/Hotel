package com.nov.hotel.dao.interfaces;

import com.nov.hotel.entities.AppartType;

import java.util.List;

public interface AppartTypeDao {
    //Create
    void insert(AppartType appartType);

    //Read
    AppartType getById(int id);

    //Read
    AppartType getByName(String name);

    //Read All
    List<AppartType> getAll();

    //Update
    void update(AppartType appartType);

    //Delete
    void delete(int id);

    //Delete
    void deleteAll();

    //Count
    int count();
}
