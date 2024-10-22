package com.hsb.leetcode.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建两个线程，交替打印出奇数和偶数
 */
public class Cross_Printing {
    private static final int MAX_PRINT_NUM = 100;
    private static final int THREAD_COUNT = 2;
    private static int currentPrintNum = 0;
    private static int currentThreadId = 0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int tmpThreadId = i;
            conditions[i] = lock.newCondition();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (currentPrintNum < MAX_PRINT_NUM) {
                        try {
                            lock.lock();
                            while (tmpThreadId != currentThreadId) {
                                conditions[tmpThreadId].await();
                            }
                            System.out.println("当前线程" + tmpThreadId + " 打印数字：" + currentPrintNum);
                            currentPrintNum++;
                            currentThreadId = (currentThreadId+1) % THREAD_COUNT;
                            conditions[currentThreadId].signal();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }).start();
        }
    }

    public static void main2(String[] args) {
        Semaphore[] semaphores = new Semaphore[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadId = i;
            semaphores[threadId] = new Semaphore(1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (currentPrintNum < MAX_PRINT_NUM) {
                        try {
                            while (currentThreadId != threadId) {
                                semaphores[threadId].release();
                            }
                            System.out.println("当前线程" + threadId + " 打印数字：" + currentPrintNum);
                            currentThreadId = (currentThreadId+1) % THREAD_COUNT;
                            currentPrintNum++;
                            semaphores[currentThreadId].acquire();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        }
    }
}
