package com.example.sptest.bean;

import com.example.sptest.bean.dto.CanOpenRequest;
import com.example.sptest.bean.service.InletServiceImpl;
import com.example.sptest.bean.service.PartnerXC;
import com.example.sptest.bean.service.PartnerYJY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        private PartnerYJY partnerYJY;
        @Autowired
        private PartnerXC partnerXC;

        @GetMapping("/")
        public void exec() {
            CanOpenRequest req = new CanOpenRequest();
            req.setAppId("2");
            inletService.canOpen(req);

            partnerYJY.getOnlineAppId();
        }

        @GetMapping("/noop")
        public void noop() {
            CanOpenRequest req = new CanOpenRequest();
            inletService.canOpen(req);
        }
    }
}
