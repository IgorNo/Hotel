package com.nov.hotel.dao.interfaces;

import java.util.List;

public interface GetDao<E,O,P> {
    //Read
    E getOne(O id);

    //Read
    List<E> getPart(P key);
}
