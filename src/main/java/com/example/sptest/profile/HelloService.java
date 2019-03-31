package com.example.sptest.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Service
@Profile("online")
public class HelloService implements Hello{

    @Override
    public void hi() {
        System.out.println(this+":online");
    }
}
