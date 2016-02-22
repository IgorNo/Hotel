package com.nov.hotel.dao.interfaces;


import com.nov.hotel.entities.AppartStatus;
import com.nov.hotel.entities.AppartType;
import com.nov.hotel.entities.Appartment;

import java.util.List;

public interface AppartmentDao {
    //Create
    void insert(Appartment appartment);

    //Read
    Appartment getById(int id);

    //Read
    Appartment getByRoomNumber(String roomNumber);

    //Read
    List<Appartment> getByStatus(AppartStatus status);

    //Read
    List<Appartment> getByType(AppartType type);

    //Read All
    List<Appartment> getAll();

    //Update
    void update(Appartment appartment);

    //Delete
    void delete(int id);
}
