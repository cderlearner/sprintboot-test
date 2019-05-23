package com.example.sptest;

/**
 * Author: linjx
 * Date: 2019/5/23
 */
public class Foo {
    private String tmp;

    private Foo() {}

    private Foo(String tmp) {
        this.tmp = tmp;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "tmp='" + tmp + '\'' +
                '}';
    }
}
