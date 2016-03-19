package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.SimpleStringProperty;

public class Block implements Entity<Block> {

    private int id;
    private SimpleStringProperty name = new SimpleStringProperty();

    public Block() {
    }

    public Block(Block block) {
        this();
        assign(block);
    }

    @Override
    public boolean validate() {
        return getName() != null;
    }

    @Override
    public void assign(Block block) {
        setId(block.getId());
        setName(block.getName());
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

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
