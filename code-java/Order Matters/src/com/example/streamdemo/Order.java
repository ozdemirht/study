package com.example.streamdemo;

import java.util.stream.Stream;

public class Order {
    public static void main(String[] args) {

        Stream.of("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN").
                map(s -> {
                    System.out.println("In map: " + s);
                    return s.toUpperCase();
                }).filter(s -> {
                    System.out.println("In filter: " + s);
                    return s.startsWith("J");
                }).
                forEach(s -> System.out.println("In forEach: " + s));

        Stream.of("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN", "JTEST").
                filter(s -> {
                    System.out.println("In filter: " + s);
                    return s.startsWith("J");
                }).
                map(s -> {
                    System.out.println("In map: " + s);
                    return s.toUpperCase();
                }).forEach(s -> System.out.println("In forEach: " + s));
    }
}
