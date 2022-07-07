package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Processor {
    private int id;
    private Long amount;
    private Type type;


    public Processor(Long amount, Type type, int id) {
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

        System.out.println("Filter Example");
        transactionList.stream()
                .filter((t) -> {
                    System.out.println(t.getType() == Type.DEBIT);
                    return t.getType() == Type.DEBIT;
                }).count();

        System.out.println(transactionList.stream()
                .filter((t) -> {
                    System.out.println(t.getType() == Type.DEBIT);
                    return t.getType() == Type.DEBIT;
                }).count());

        System.out.println("Map Example");
        transactionList.stream()
                .map((t) -> {
                    System.out.println("In map: " + t.getAmount());
                    return t.getAmount();
                }).forEach(s -> System.out.println("In for Each: " + s));

        System.out.println("Chaining Example");
        transactionList.stream()
                .filter((t) -> {
                    System.out.println(t.getType() == Type.DEBIT);
                    return t.getType() == Type.DEBIT;
                }).map((t) -> {
                    System.out.println("In map: " + t.getAmount());
                    return t.getAmount();
                }).forEach(s -> System.out.println("In for Each: " + s));

        System.out.println("Chaining Example (Concise)");
        transactionList.stream()
                .filter(t -> t.getType() == Type.DEBIT)
                .map(t -> t.getAmount())
                .forEach(s -> System.out.println("In for Each: " + s));

        System.out.println("Sorting Example");
        transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .forEach(s -> System.out.println("In for Each: " + s.getId() +" , " + s.getAmount()));
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




