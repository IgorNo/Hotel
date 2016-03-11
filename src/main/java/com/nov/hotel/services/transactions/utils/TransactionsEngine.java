package com.nov.hotel.services.transactions.utils;

import com.nov.hotel.services.transactions.interfaces.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionsEngine {

    LinkedList<Transaction> transactions = new LinkedList<>();

    public List<String> getExceptMess() {
        return exceptMess;
    }

    List<String> exceptMess = new LinkedList<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void run(){
        while (!transactions.isEmpty()) {
            Transaction t = transactions.getFirst();
            t.execute();
            if (t.getExceptionMessage() != null)
                exceptMess.add(t.getExceptionMessage());
            else
                transactions.removeFirst();
        }
    }

    public boolean isEmpty() {
        return transactions.size() == 0;
    }

}
