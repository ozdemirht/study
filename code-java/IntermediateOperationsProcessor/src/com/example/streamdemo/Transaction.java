package com.example.streamdemo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;


enum Type {
    DEBIT, CREDIT
}

public class Transaction {
    private int id;
    private Long amount;
    private Type type;


    public Transaction(Long amount, Type type, int id) {
        this.amount = amount;
        this.type = type;
        this.id = id;
    }

    public static void main(String[] args) {
        Transaction a = new Transaction(1000L, Type.DEBIT, 1);
        Transaction b = new Transaction(10000L, Type.CREDIT, 2);
        Transaction c = new Transaction(50000L, Type.DEBIT, 3);
        Transaction d = new Transaction(70000L, Type.DEBIT, 4);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(a);
        transactionList.add(b);
        transactionList.add(c);
        transactionList.add(d);

        List<Transaction> debitTransactions = new ArrayList<>();
        for (Transaction transaction : transactionList) {

            if (transaction.getType() == Type.DEBIT) {
                debitTransactions.add(transaction);
            }
        }
        Collections.sort(debitTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t2.getAmount().compareTo(t1.getAmount());
            }
        });
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : debitTransactions) {
            transactionIds.add(t.getId());
        }
        System.out.println(transactionIds);

        List<Integer> streamedtransactionsIds =
                transactionList.stream()
                        .filter((t) -> {
                            return t.getType() == Type.DEBIT;
                        })
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                        //.map(Transaction::getId)
                        .map(t -> t.getId())
                        .collect(toList());
        System.out.println(streamedtransactionsIds);

    }


    public Long getAmount() {
        return this.amount;
    }

    public Enum getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public void setId(final int id) {
        this.id = id;
    }

}



