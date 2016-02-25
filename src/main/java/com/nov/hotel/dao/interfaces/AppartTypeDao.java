package com.nov.hotel.dao.interfaces;

import com.nov.hotel.entities.ApartType;

import java.util.List;

public interface AppartTypeDao {
    //Create
    void insert(ApartType apartType);

    //Read
    ApartType getById(int id);

    //Read
    ApartType getByName(String name);

    //Read All
    List<ApartType> getAll();

    //Update
    void update(ApartType apartType);

    //Delete
    void delete(int id);

    //Delete
    void deleteAll();

    //Count
    int count();
}
