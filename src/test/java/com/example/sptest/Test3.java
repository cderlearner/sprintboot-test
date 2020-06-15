package com.example.sptest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟mesa模型实现机制
 */
public class Test3 {

    static class BlockQueue<T> {

        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();
        List<T> elements = new ArrayList<>();
        private final int maxSize;

        public BlockQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        private boolean isFull() {
            return elements.size() == maxSize;
        }

        private boolean isEmpty() {
            System.out.println(Thread.currentThread().getName() + ": deq 线程在while处做判断");
            return elements.size() == 0;
        }

        public void enq(T x) {
            System.out.println(Thread.currentThread().getName() + ": enq 线程开始");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": enq 线程获取到Lock");
            try {
                while (isFull()) {
                    notFull.await();
                }
                elements.add(x);
                // 入队后, 通知可出队
                System.out.println(Thread.currentThread().getName() + ": enq 线程入队通知");
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 不释放锁
                //lock.unlock();
            }
        }

        public T deq() {
            System.out.println(Thread.currentThread().getName() + ": deq 线程开始");
            lock.lock();
            System.err.println(Thread.currentThread().getName() + ": deq 线程获取到Lock");
            try {
                while (isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + ": deq 线程： 队列为空，准备wait");
                    notEmpty.await();
                }
                System.out.println(Thread.currentThread().getName() + ": deq 线程被nofity，开始执行");
                T e = elements.remove(0);
                notFull.signal();
                // TimeUnit.MILLISECONDS.sleep(300);
                return e;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> queue = new BlockQueue<>(1);

        for (int i = 0; i < 2; i++) {
            Thread deq = new Thread(() -> queue.deq());
            deq.start();
        }

        Thread enq = new Thread(() -> queue.enq(1));

        TimeUnit.SECONDS.sleep(1);
        enq.start();

        enq.join();
        System.err.println("=====================  add element done  =========================");

        TimeUnit.SECONDS.sleep(200);

    }

}
