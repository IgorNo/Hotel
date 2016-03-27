package com.nov.hotel.entities.interfaces;

public interface Entity<E> {
    void assign(E elem);
    boolean validate();
}
