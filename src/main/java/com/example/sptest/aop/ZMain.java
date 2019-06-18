package com.example.sptest.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: linjx
 * Date: 2019/6/16
 */
@EnableAspectJAutoProxy()
@SpringBootApplication
public class ZMain {

    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/linjiaxing/Documents/cglib_gen");
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ConfigurableApplicationContext app = SpringApplication.run(ZMain.class, args);
        TestBean bean = app.getBean(TestBean.class);
        bean.test();
    }
}