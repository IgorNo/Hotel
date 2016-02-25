package com.nov.hotel.services.interfaces;

import com.nov.hotel.entities.ApartType;

import java.util.List;

public interface ApartTypeService {
    //Create
    ApartTypeService insert(ApartType apartType);

    //Read
    ApartType getById(int id);

    //Read
    ApartType getByName(String name);

    //Read All
    List<ApartType> getAll();

    //Update
    ApartTypeService update(ApartType apartType);

    //Delete
    ApartTypeService delete(int id);

    //Count
    int count();
}
