package com.nov.hotel.entities;

import java.time.LocalDate;

public class Reservation {
    private long id;
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;
    private Appartment appartment;
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Appartment getAppartment() {
        return appartment;
    }

    public void setAppartment(Appartment appartment) {
        this.appartment = appartment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
