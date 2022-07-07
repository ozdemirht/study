package com.example.streamdemo;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


enum Type {
    DEBIT, CREDIT
}

enum Month {
    JAN, FEB, MARCH, APRL, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC
}

public class TransactionExample {
    private int id;
    private Long amount;
    private Type type;
    private Month month;


    public TransactionExample(Long amount, Type type, int id, Month month) {
        this.amount = amount;
        this.type = type;
        this.id = id;
        this.month = month;
    }

    public static void main(String[] args) throws IOException {
        TransactionExample a = new TransactionExample(1000L, Type.DEBIT, 1, Month.JAN);
        TransactionExample b = new TransactionExample(10000L, Type.CREDIT, 2, Month.JAN);
        TransactionExample c = new TransactionExample(50000L, Type.DEBIT, 3, Month.AUG);
        TransactionExample d = new TransactionExample(70000L, Type.DEBIT, 4, Month.JAN);

        List<TransactionExample> transactionList = new ArrayList<>();
        transactionList.add(a);
        transactionList.add(b);
        transactionList.add(c);
        transactionList.add(d);

        System.out.println(transactionList.stream()
                .collect(Collectors.groupingBy(TransactionExample::getMonth,
                        Collectors.summingLong(TransactionExample::getAmount))));

        System.out.println(transactionList.stream()
                .collect(Collectors.groupingBy(TransactionExample::getMonth,
                        Collectors.averagingLong(TransactionExample::getAmount))));

        System.out.println(transactionList.stream()
                .collect(Collectors.groupingBy(TransactionExample::getMonth,
                        Collectors.summarizingLong(TransactionExample::getAmount))));

    }


    public Long getAmount() {
        return this.amount;
    }

    public Enum getType() {
        return this.type;
    }

    public Enum getMonth() {
        return this.month;
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




