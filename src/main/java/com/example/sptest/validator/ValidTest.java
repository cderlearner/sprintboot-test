package com.example.sptest.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ValidTest implements Serializable {

    public static void main(String[] args) {
//        Student xiaoming = getBean();
//
//        StopWatch watch = new StopWatch();
//        watch.start();
//        for (int i = 0; i < 100000; i ++) {
//            List<String> validate = validate(xiaoming);
//        }
//        watch.stop();
//
//        System.out.println(watch.getTotalTimeMillis());
//
//
//        watch = new StopWatch();
//        watch.start();
//        for (int i = 0; i < 1000000; i ++) {
//            List<String> validate = validate(xiaoming);
//        }
//        watch.stop();
//
//        System.out.println(watch.getTotalTimeMillis());

//        validate.forEach(row -> {
//            System.out.println(row);
//
//        });

        List<String> validate = validate(getBean());
        validate.forEach(s -> System.out.println(s));

        validate = validate(getTeacher());
        validate.forEach(s -> System.out.println(s));
    }

    private static Student getBean() {
        Student bean = new Student();
        bean.setName(null);
        bean.setAddress("北京");
        bean.setBirthday(new Date());
        bean.setFriendName(null);
        bean.setWeight(new BigDecimal(30));
        bean.setEmail("xiaogangfan163.com");
        return bean;
    }

    private static Teacher getTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName(null);
        teacher.setUserId(1L);
        return teacher;
    }

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator;
    static {
        validator = factory.getValidator();
    }

    public static <T> List<String> validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            messageList.add(constraintViolation.getMessage());
        }
        return messageList;
    }
}