package com.example.sptest.bean.other;

/**
 * Author: linjx
 * Date: 2019/3/31
 */
public class Child extends Base{

    @Override
    public void hi() {
        System.out.println("hello world !");
    }

    public static void main(String[] args) {
        Base base = new Child();
        base.hi();
    }
}
