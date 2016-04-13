package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

public class Allocation implements Entity<Long, Allocation>, Comparable<Allocation> {

    private int id;
    private ObjectProperty<Apartment> room = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> startDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> endDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> arrivalDate = new SimpleObjectProperty<>();
    private ObjectProperty<Price> priceType = new SimpleObjectProperty<>();
    private IntegerProperty masterBedsN = new SimpleIntegerProperty();
    private IntegerProperty extraBedsN = new SimpleIntegerProperty();
    private ObjectProperty<ApartStatus> allocType = new SimpleObjectProperty<>();
    private ObjectProperty<AllocClient> clients = new SimpleObjectProperty<>();

    @Override
    public void assign(Allocation elem) {
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public int compareTo(Allocation o) {
        return 0;
    }
}
