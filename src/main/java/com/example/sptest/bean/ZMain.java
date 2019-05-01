package com.example.sptest.bean;

import com.example.sptest.bean.dto.CanOpenRequest;
import com.example.sptest.bean.dto.OrderCreateRequest;
import com.example.sptest.bean.service.InletServiceImpl;
import com.example.sptest.bean.service.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;
import java.util.List;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@SpringBootApplication
public class ZMain {

    public static void main(String[] args) {
        SpringApplication.run(ZMain.class, args);
    }

    @RestController
    class Hello {
//        @Autowired
//        @Qualifier("inletService1")
//        private InletService inletService;

        @Autowired
        private InletServiceImpl inletService;
        @Autowired
        private List<Partner> partners;
        @Autowired
        private Validator validator;

        @GetMapping("/")
        public void exec() {
//            CanOpenRequest req = new CanOpenRequest();
//            req.setAppId("2");
//            inletService.canOpen(req);

            partners.forEach(partner -> System.out.println(partner.getOnlineAppId()));
            System.out.println("hello world");
        }

        @GetMapping("/noop")
        public void noop() {
            CanOpenRequest req = new CanOpenRequest();
            inletService.canOpen(req);
        }

        @GetMapping("/valid")
        public void valid() {
            OrderCreateRequest request = OrderCreateRequest.builder()
                    .buyDays(1)
                    .mobile("+008613810522372")
                    .outOrderNo("222")
                    .openTime("2019-11-11 03:10:11")
                    .vipType("INSTABOOK")
                    .build();
            System.out.println(validator.validate(request));
        }
    }


}
