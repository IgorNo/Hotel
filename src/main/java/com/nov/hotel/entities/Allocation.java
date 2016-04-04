package com.nov.hotel.entities;

import com.nov.hotel.collections.impl.ClientCollection;
import com.nov.hotel.collections.interfaces.ObservableCollection;
import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

public class Allocation implements Entity<Allocation> {

    private int id;
    private ObjectProperty<Apartment> room = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> startDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> endDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> arrivalDate = new SimpleObjectProperty<>();
    private ObjectProperty<Price> priceType = new SimpleObjectProperty<>();
    private IntegerProperty masterBadsN = new SimpleIntegerProperty();
    private IntegerProperty extraBadsN = new SimpleIntegerProperty();
    private ObjectProperty<ApartStatus> allocType = new SimpleObjectProperty<>();
    private ObservableCollection<Client> clients = ClientCollection.getInstance();

    @Override
    public void assign(Allocation elem) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
