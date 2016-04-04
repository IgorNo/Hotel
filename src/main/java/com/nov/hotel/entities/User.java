package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;

public class User implements Entity<User> {
    @Override
    public void assign(User elem) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
