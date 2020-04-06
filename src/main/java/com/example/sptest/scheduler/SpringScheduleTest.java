package com.example.sptest.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class SpringScheduleTest {

    private AtomicInteger taskNumber = new AtomicInteger(0);
    private AtomicInteger task1Number = new AtomicInteger(0);

    @Scheduled(cron = "*/5 * * * * ? ")
    public void remindTask() throws InterruptedException {
        log.info("每隔5秒执行一次, 当前线程名称{} 当前执行次数{}", Thread.currentThread().getName(), taskNumber.incrementAndGet());
        System.out.println("0-----------------------");
    }

    /**
     * 固定频率执行。fixedDelay的单位是ms
     */
    @Scheduled(fixedDelay = 1000)
    public void remindTask2() throws InterruptedException {
        log.info("每隔1s执行一次 当前线程名称{} 当前执行次数{}", Thread.currentThread().getName(), task1Number.incrementAndGet());
        System.out.println("2-----------------------");
    }
}