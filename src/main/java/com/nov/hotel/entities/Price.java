package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.*;

public class Price implements Entity<Price> {

    private int id;
    private StringProperty name = new SimpleStringProperty();
    private FloatProperty price = new SimpleFloatProperty();

    public Price() {
    }

    public Price(Price elem) {
        this();
        assign(elem);
    }

    @Override
    public void assign(Price elem) {
        setId(elem.getId());
        setName(elem.getName());
        setPrice(elem.getPrice());
    }

    @Override
    public boolean validate() {
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}