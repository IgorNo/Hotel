package com.nov.hotel.services.interfaces;

import com.nov.hotel.entities.AppartType;

import java.util.List;

public interface AppartTypeService {
    //Create
    AppartTypeService insert(AppartType appartType);

    //Read
    AppartType getById(int id);

    //Read
    AppartType getByName(String name);

    //Read All
    List<AppartType> getAll();

    //Update
    AppartTypeService update(AppartType appartType);

    //Delete
    AppartTypeService delete(int id);

    //Count
    int count();
}
