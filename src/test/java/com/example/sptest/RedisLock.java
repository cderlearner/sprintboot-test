package com.example.sptest;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * Author: linjx
 * Date: 2019/4/29
 */
public class RedisLock {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    private String key;
    private int expireTime;
    private TimeUnit timeUnit;
    private StringRedisTemplate redisTemplate;

    // 用于保证锁释放原子性
    private String randomValue;
    private boolean isLocked = false;

    public RedisLock(String key,
                     int expireTime,
                     TimeUnit timeUnit,
                     StringRedisTemplate redisTemplate) {
        this.key = key;
        this.expireTime = expireTime;
        this.timeUnit = timeUnit;
        this.redisTemplate = redisTemplate;
        this.randomValue = RandomStringUtils.randomAlphanumeric(11);
    }

    /**
     * 非阻塞获取锁，获取失败跳过
     *
     * @return
     */
    public boolean tryLock() {
        try {
            RedisCallback<Boolean> callback = (connection) -> {
                return connection.set(
                        key.getBytes(Charset.forName("UTF-8")),
                        randomValue.getBytes(Charset.forName("UTF-8")),
                        Expiration.milliseconds(timeUnit.toMillis(expireTime)),
                        RedisStringCommands.SetOption.SET_IF_ABSENT);   //setNx命令
            };
            isLocked = redisTemplate.execute(callback);
            logger.warn("Get redisLock success:" + key);  //打印下日志 检查是否上锁成功
            return isLocked;
        } catch (Exception ex) {
            logger.error("Redis lock error:" + ex.getMessage(), ex);
        }
        return false;
    }

    /**
     * 超时指定时间获取锁
     *
     * @param timeout
     * @param timeUnit
     * @return
     */
    public boolean tryLock(long timeout, TimeUnit timeUnit) {
        long nanoTimeout = timeUnit.toNanos(timeout);
        long nowTime = System.nanoTime();
        while ((System.nanoTime() - nowTime) < nanoTimeout) {
            if (tryLock()) {
                return true;
            }

            sleep(10);
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @return
     */
    public void unLock() {
        try {
            if (isLocked) {
                RedisCallback<Boolean> callback = (connection) -> connection.eval(
                        UNLOCK_LUA.getBytes(),
                        ReturnType.BOOLEAN,
                        1,
                        key.getBytes(Charset.forName("UTF-8")),
                        randomValue.getBytes(Charset.forName("UTF-8")));
                boolean ret = redisTemplate.execute(callback);
                if (ret) {
                    logger.warn("Unlock redisLock success:" + key);  //打印下日志 检查是否释放锁成功
                }
            }
        } catch (Exception ex) {
            logger.error("Redis unlock error:" + ex.getMessage(), ex);
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
