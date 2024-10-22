package com.hsb.leetcode.juc;

import java.util.concurrent.Semaphore;

public class HelloWorldSemaphore {
    private static final int THREAD_COUNT = 3;
    private static int currentThread = 0;
    private static final Semaphore[] semaphores = new Semaphore[THREAD_COUNT];

    public static void main(String[] args) {
        // 初始化信号量，确保第一个线程开始时信号量可用
        for (int i = 0; i < THREAD_COUNT; i++) {
            semaphores[i] = new Semaphore(i == 0 ? 1 : 0); // 第一个线程信号量设置为 1，其余为 0
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) { // 每个线程打印 5 次
                    try {
                        semaphores[threadId].acquire(); // 获取信号量，确保按顺序执行
                        System.out.println("Hello World from Thread " + (threadId + 1));
                        semaphores[(threadId + 1) % THREAD_COUNT].release(); // 释放下一个线程的信号量
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}
