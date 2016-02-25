package com.nov.hotel.entities;

public class Apartment {
    private long id;
    private String roomNumber;
    private int levelNumber;
    private int sizing;
    private ApartStatus status;
    private ApartType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getSizing() {
        return sizing;
    }

    public void setSizing(int sizing) {
        this.sizing = sizing;
    }

    public ApartStatus getStatus() {
        return status;
    }

    public void setStatus(ApartStatus status) {
        this.status = status;
    }

    public ApartType getType() {
        return type;
    }

    public void setType(ApartType type) {
        this.type = type;
    }
}
