package com.nov.hotel.entities.interfaces;

public interface Entity<E> {
    boolean validate();
    void assign(E elem);
}
