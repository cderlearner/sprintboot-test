package com.example.sptest;

import java.nio.charset.CharsetDecoder;
import java.util.function.Consumer;

public class TestMain1 {
    public static void main(String[] args) {
//        Consumer consumer = (s) -> System.out.println(s+ "hello world");
//        consumer.accept("sss");
//
//        System.out.println(consumer.getClass().getClassLoader());

        String key = "follow:each:2639043308:2639043308";   // 33字节
        String v1 = "1586175722869:1586175722869";          // 27字节

        System.out.println("k1:" + getLength(key));
        System.out.println("v1:" + getLength(v1));
        System.out.println(getLength("aa"));

        // 8864787  匿名sorteset列表个数 1.2g

        // 2000个kv结构 内存预估换算公式
        // 2000 * （32+ 16+ 48+ 32）+ 2048 * 8

        // 套用上面公式
        // 8864787 * 128 + 1048576（向上取整2的n次最小值） * 8
        // 1134692736 + 8388608
        // 1143081344

        // 1090.127319336 m == 1.06 g
    }

    public static int getLength(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255) {
                length++;
            } else {
                length += 2;
            }
        }
        return length;
    }
}
