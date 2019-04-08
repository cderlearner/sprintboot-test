package com.example.sptest.aspect;

import com.example.sptest.aspect.mapper.PartnerEventDao;
import com.example.sptest.aspect.service.LogService;
import com.example.sptest.bean.dto.OrderCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.example.sptest.aspect.mapper")
public class MybatisDemoApplication implements ApplicationRunner {

    @Autowired
    private PartnerEventDao eventDao;
    @Autowired
    private LogService logService;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logService.foo(OrderCreateRequest.builder().appId("1").buyDays(1).contractId("1").mobile("+86").outOrderNo("1").build());

        PartnerEventModel eventModel = eventDao.findById(1L);
        log.info("PartnerEventModel {}", eventModel);
    }
}

