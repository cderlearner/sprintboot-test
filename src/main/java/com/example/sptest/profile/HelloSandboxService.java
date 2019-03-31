package com.example.sptest.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Service
@Profile("sandbox")
public class HelloSandboxService implements Hello {

    @Override
    public void hi() {
        System.out.println(this+":sandbox");
    }
}
