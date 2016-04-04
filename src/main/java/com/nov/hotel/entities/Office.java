package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;

public class Office implements Entity<Office> {
    @Override
    public void assign(Office elem) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
