package com.nov.hotel.services.interfaces;

import java.util.List;

public interface GetService<E> {

    //Read
    E getById(int id);

    //Read
    List<E> getByName(String name);

    //Read All
    List<E> getAll();

    //Count
    int count();
}
