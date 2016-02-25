package com.nov.hotel.dao.interfaces;


import com.nov.hotel.entities.ApartStatus;
import com.nov.hotel.entities.ApartType;
import com.nov.hotel.entities.Apartment;

import java.util.List;

public interface ApartmentDao {
    //Create
    void insert(Apartment apartment);

    //Read
    Apartment getById(int id);

    //Read
    Apartment getByRoomNumber(String roomNumber);

    //Read
    List<Apartment> getByStatus(ApartStatus status);

    //Read
    List<Apartment> getByType(ApartType type);

    //Read All
    List<Apartment> getAll();

    //Update
    void update(Apartment apartment);

    //Delete
    void delete(int id);
}
