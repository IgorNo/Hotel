package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.SimpleStringProperty;

public class ApartStatus implements Entity<ApartStatus>{
    private int id;
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty color = new SimpleStringProperty();

    public ApartStatus() {    }

    public ApartStatus(ApartStatus apartType){
        setId(apartType.getId());
        setName(apartType.getName());
        setColor(apartType.getColor());
    }

    public void assign(ApartStatus apartType){
        setId(apartType.getId());
        setName(apartType.getName());
        setColor(apartType.getColor());
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

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    @Override
    public boolean validate() {
        return getName() != "" && getColor() != "";
    }

}
