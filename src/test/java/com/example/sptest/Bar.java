package com.example.sptest;

import java.util.concurrent.TimeUnit;

/**
 * Author: linjx
 * Date: 2019/5/23
 */
public class Bar {
    public static int tmp = 1;
    public static final int tmp2 = 2;
    public static final Bar INS = new Bar();

    static {
        try {
            TimeUnit.SECONDS.sleep(2l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bar");
    }

    public Bar(){
        System.out.println("ba2");
    }

    public void f1() {
        System.out.println("f1");
    }

    public static void f2() {
        System.out.println("f2");
    }

    public static final void f3() {
        System.out.println("f3");
    }
}
