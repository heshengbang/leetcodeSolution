package com.hsb.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorldThreads {
    private static final int THREAD_COUNT = 3; // 假设n为3
    private static int currentThread = 0; // 当前应该打印的线程
    private static final Lock lock = new ReentrantLock();
    private static final Condition[] conditions = new Condition[THREAD_COUNT];

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            conditions[i] = lock.newCondition();
            final int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) { // 每个线程打印5次
                    lock.lock();
                    try {
                        while (currentThread != threadId) {
                            conditions[threadId].await();
                        }
                        System.out.println("Hello World from Thread " + (threadId + 1));
                        currentThread = (currentThread + 1) % THREAD_COUNT;
                        conditions[currentThread].signal();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
