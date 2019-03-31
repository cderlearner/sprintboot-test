package com.example.sptest.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Service
public class RetryService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Async
    @Retryable(maxAttempts = 5, backoff = @Backoff(10))
    public void test() {
        logger.error("所在线程：" + Thread.currentThread().getName());
        //throw new RuntimeException("hh");
    }
}
