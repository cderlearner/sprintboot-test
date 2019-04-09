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
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@Slf4j
@MapperScan("com.example.sptest.aspect.mapper")
public class MybatisDemoApplication implements ApplicationRunner {

    @Autowired
    private PartnerEventDao eventDao;
    @Autowired
    private LogService logService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        OrderCreateRequest req = OrderCreateRequest.builder().appId("1").buyDays(1).contractId("1").mobile("+86").outOrderNo("1").build();

        try {
            logService.foo(req);
        } catch (Exception ex) {
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }

        try {
            logService.execute();
        } catch (Exception ex) {
            log.info("CCC {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='CCC'", Long.class));
        }

//        logService.insertThenRollback(req);
//        PartnerEventModel eventModel = eventDao.findById(1L);
//        log.info("PartnerEventModel {}", eventModel);
    }

}

