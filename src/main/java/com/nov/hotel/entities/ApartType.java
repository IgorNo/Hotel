package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Validate;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ApartType implements Validate{
    private int id;
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty sizing = new SimpleIntegerProperty();
    private SimpleFloatProperty price1 = new SimpleFloatProperty();
    private SimpleFloatProperty price2 = new SimpleFloatProperty();
    private SimpleFloatProperty price3 = new SimpleFloatProperty();

    public ApartType() { }

    public ApartType(ApartType apartType){
        setId(apartType.getId());
        setName(apartType.getName());
        setSizing(apartType.getSizing());
        setPrice1(apartType.getPrice1());
        setPrice2(apartType.getPrice2());
        setPrice3(apartType.getPrice3());
    }

    public void assign(ApartType apartType){
        setId(apartType.getId());
        setName(apartType.getName());
        setSizing(apartType.getSizing());
        setPrice1(apartType.getPrice1());
        setPrice2(apartType.getPrice2());
        setPrice3(apartType.getPrice3());
    }

    @Override
    public boolean validate() {
        return  name != null && getName() != "" && sizing != null && getSizing() > 0
                && price1 != null && price2 != null && price3 != null;
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

    public void setName(String name) {
        this.name.set(name);
    }

    public int getSizing() {
        return sizing.get();
    }

    public SimpleIntegerProperty sizingProperty() {
        return sizing;
    }

    public void setSizing(int sizing) {
        this.sizing.set(sizing);
    }

    public float getPrice1() {
        return price1.get();
    }

    public void setPrice1(float price) {
        this.price1.set(price);
    }

    public float getPrice2() {
        return price2.get();
    }

    public void setPrice2(float price) {
        this.price2.set(price);
    }

    public float getPrice3() {
        return price3.get();
    }

    public void setPrice3(float price) {
        this.price3.set(price);
    }

    public SimpleStringProperty nameProperty(){ return name; }

    public SimpleFloatProperty price1Property(){ return price1; }

    public SimpleFloatProperty price2Property(){ return price2; }

    public SimpleFloatProperty price3Property(){ return price3; }

    @Override
    public String toString() {
        return "ApartType{" +
                "id=" + id +
                ", name=" + name +
                ", sizing=" + sizing +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", price3=" + price3 +
                '}';
    }

}
