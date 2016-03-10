package com.nov.hotel.services.transactions.utils;

import com.nov.hotel.services.transactions.interfaces.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionsEngine {

    LinkedList<Transaction> itsTransactions = new LinkedList<>();
    List<String> itsExceptionMessages = new LinkedList<>();

    public void addTransaction(Transaction transaction){
        itsTransactions.add(transaction);
    }

    public void run(){
        while (!itsTransactions.isEmpty()) {
            Transaction t = itsTransactions.getFirst();
            itsTransactions.removeFirst();
            t.execute();
            if (t.getExceptionMessage() !=null)
                itsExceptionMessages.add(t.getExceptionMessage());
        }
    }
}
