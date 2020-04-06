package com.example.sptest;

import java.util.function.Consumer;

public class TestMain1 {
    public static void main(String[] args) {
        Consumer consumer = (s) -> System.out.println(s+ "hello world");
        consumer.accept("sss");

        System.out.println(consumer.getClass().getClassLoader());
    }
}
