package com.nov.hotel.entities;

public class Appartment {
    private long id;
    private String roomNumber;
    private int levelNumber;
    private int sizing;
    private AppartStatus status;
    private AppartType type;

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

    public AppartStatus getStatus() {
        return status;
    }

    public void setStatus(AppartStatus status) {
        this.status = status;
    }

    public AppartType getType() {
        return type;
    }

    public void setType(AppartType type) {
        this.type = type;
    }
}
