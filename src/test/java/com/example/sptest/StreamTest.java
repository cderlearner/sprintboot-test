package com.example.sptest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

        Stream<String> stream = ls.stream();

        stream.anyMatch((q) -> "1".equals(q));
    }
}
