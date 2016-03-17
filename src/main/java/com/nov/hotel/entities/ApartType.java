package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.*;

public class ApartType implements Entity<ApartType> {

    private int id;
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty size = new SimpleIntegerProperty();
    private FloatProperty priceDay = new SimpleFloatProperty();
    private FloatProperty priceHour = new SimpleFloatProperty();
    private IntegerProperty nSlots = new SimpleIntegerProperty();
    private FloatProperty priceSlot = new SimpleFloatProperty();
    private StringProperty description = new SimpleStringProperty();


    public ApartType() { }

    public ApartType(ApartType apartType){
        this();
        assign(apartType);
    }

    public void assign(ApartType apartType){
        setId(apartType.getId());
        setName(apartType.getName());
        setSize(apartType.getSize());
        setPriceDay(apartType.getPriceDay());
        setPriceHour(apartType.getPriceHour());
        setPriceSlot(apartType.getPriceSlot());
        setnSlots(apartType.getnSlots());
        setDescription(apartType.getDescription());
    }

    @Override
    public boolean validate() {
        return getName() != "" && getSize() > 0;
    }

    @Override
    public String toString() {
        return getName();
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

    public int getSize() {
        return size.get();
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public void setSize(int size) {
        this.size.set(size);
    }

    public float getPriceDay() {
        return priceDay.get();
    }

    public FloatProperty priceDayProperty() {
        return priceDay;
    }

    public void setPriceDay(float priceDay) {
        this.priceDay.set(priceDay);
    }

    public float getPriceHour() {
        return priceHour.get();
    }

    public FloatProperty priceHourProperty() {
        return priceHour;
    }

    public void setPriceHour(float priceHour) {
        this.priceHour.set(priceHour);
    }

    public int getnSlots() {
        return nSlots.get();
    }

    public IntegerProperty nSlotsProperty() {
        return nSlots;
    }

    public void setnSlots(int nSlots) {
        this.nSlots.set(nSlots);
    }

    public float getPriceSlot() {
        return priceSlot.get();
    }

    public FloatProperty priceSlotProperty() {
        return priceSlot;
    }

    public void setPriceSlot(float priceSlot) {
        this.priceSlot.set(priceSlot);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

}
