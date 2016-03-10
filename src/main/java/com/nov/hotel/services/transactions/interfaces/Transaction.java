package com.nov.hotel.services.transactions.interfaces;

// Pattern Transaction
public interface Transaction {

    void execute();

    String getExceptionMessage();
}
