package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Apartment implements Entity<Apartment> {

    private long id;
    private SimpleStringProperty roomNumber = new SimpleStringProperty();
    private SimpleIntegerProperty nAdditionalSlot = new SimpleIntegerProperty();
    private SimpleIntegerProperty levelNumber = new SimpleIntegerProperty();
    private SimpleStringProperty block = new SimpleStringProperty();
    private SimpleBooleanProperty status = new SimpleBooleanProperty();
    private ApartType type;

    public Apartment() {  }

    public Apartment(Apartment apartment) {
        this();
        assign(apartment);
    }

    @Override
    public void assign(Apartment apartment) {
        setId(apartment.getId());
        setRoomNumber(apartment.getRoomNumber());
        setnAdditionalSlot(apartment.getnAdditionalSlot());
        setLevelNumber(apartment.getLevelNumber());
        setBlock(apartment.getBlock());
        setStatus(apartment.getStatus());
        type = new ApartType(apartment.getType());
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

    public int getnAdditionalSlot() {
        return nAdditionalSlot.get();
    }

    public SimpleIntegerProperty nAdditionalSlotProperty() {
        return nAdditionalSlot;
    }

    public void setnAdditionalSlot(int nAdditionalSlot) {
        this.nAdditionalSlot.set(nAdditionalSlot);
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

    public String getBlock() {
        return block.get();
    }

    public SimpleStringProperty blockProperty() {
        return block;
    }

    public void setBlock(String block) {
        this.block.set(block);
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

    public ApartType getType() {
        return type;
    }

    public void setType(ApartType type) {
        this.type = type;
    }

    @Override
    public boolean validate() {
        return false;
    }

}
