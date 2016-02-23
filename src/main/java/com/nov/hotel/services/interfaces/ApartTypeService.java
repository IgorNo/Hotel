package com.nov.hotel.services.interfaces;

import com.nov.hotel.entities.AppartType;

import java.util.List;

public interface ApartTypeService {
    //Create
    ApartTypeService insert(AppartType appartType);

    //Read
    AppartType getById(int id);

    //Read
    AppartType getByName(String name);

    //Read All
    List<AppartType> getAll();

    //Update
    ApartTypeService update(AppartType appartType);

    //Delete
    ApartTypeService delete(int id);

    //Count
    int count();
}
