package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Apartment implements Entity<Apartment> {

    private long id;
    private SimpleStringProperty roomNumber = new SimpleStringProperty();
    private SimpleIntegerProperty levelNumber = new SimpleIntegerProperty();
    private SimpleObjectProperty<Block> block = new SimpleObjectProperty<>();
    private SimpleBooleanProperty status = new SimpleBooleanProperty();
    private SimpleObjectProperty<ApartType> type = new SimpleObjectProperty<>();

    public Apartment() {  }

    public Apartment(ApartType type, Block block) {
        setType(type);
        setBlock(block);
    }

    public Apartment(Apartment apartment) {
        this();
        assign(apartment);
    }

    @Override
    public void assign(Apartment apartment) {
        setId(apartment.getId());
        setRoomNumber(apartment.getRoomNumber());
        setLevelNumber(apartment.getLevelNumber());
        setBlock(apartment.getBlock());
        setStatus(apartment.getStatus());
        setType(apartment.getType());
    }

    @Override
    public boolean validate() {
        return getRoomNumber() != null && !getRoomNumber().trim().isEmpty() && getBlock() != null && getType() != null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public SimpleStringProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public int getLevelNumber() {
        return levelNumber.get();
    }

    public SimpleIntegerProperty levelNumberProperty() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber.set(levelNumber);
    }

    public boolean getStatus() {
        return status.get();
    }

    public SimpleBooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    public Block getBlock() {
        return block.get();
    }

    public SimpleObjectProperty<Block> blockProperty() {
        return block;
    }

    public void setBlock(Block block) {
        this.block.set(block);
    }

    public ApartType getType() {
        return type.get();
    }

    public SimpleObjectProperty<ApartType> typeProperty() {
        return type;
    }

    public void setType(ApartType type) {
        this.type.set(type);
    }

    @Override
    public String toString() {
        return getRoomNumber();
    }
}
