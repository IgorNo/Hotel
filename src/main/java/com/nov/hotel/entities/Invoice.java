package com.nov.hotel.entities;

import com.nov.hotel.entities.interfaces.Customer;
import com.nov.hotel.entities.interfaces.Entity;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Invoice implements Entity<Invoice> {

    private long id;
    private ObjectProperty<LocalDateTime> createTime = new SimpleObjectProperty<>();
    private StringProperty invoiceN = new SimpleStringProperty();
    private ObjectProperty<LocalDate> invoiceDate = new SimpleObjectProperty<>();
    private FloatProperty amount = new SimpleFloatProperty();
    private ObjectProperty<Customer> ownerIndivid = new SimpleObjectProperty<>();
    private ObjectProperty<User> user = new SimpleObjectProperty<>();


    @Override
    public void assign(Invoice elem) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
