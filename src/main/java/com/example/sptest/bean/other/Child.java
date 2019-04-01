package com.example.sptest.bean.other;

import com.example.sptest.bean.dto.CanOpenRequest;
import com.example.sptest.bean.dto.Pojo;

/**
 * Author: linjx
 * Date: 2019/3/31
 */
public class Child extends Base{

    @Override
    public void hi() {
        System.out.println("hello world !");
    }


    public static void pojo(Pojo pojo) {
        //CanOpenRequest req = (CanOpenRequest) pojo;
        System.out.println(pojo);
    }

    public static void main(String[] args) {
        Base base = new Child();
        base.hi();

        CanOpenRequest canOpenRequest = new CanOpenRequest();
        canOpenRequest.setMobile("128");
        canOpenRequest.setAppId("111");
        pojo(canOpenRequest);
    }
}
