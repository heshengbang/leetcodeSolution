package com.hsb.leetcode.juc;

import java.util.concurrent.Semaphore;

public class CyclePrintWithSemaphore {

    public static void main(String[] args) {

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);


        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("第" + 1 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                try {
                    s1.acquire();
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    s2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            Thread.currentThread().setName("第" + 2 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                try {
                    s2.acquire();
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    s3.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread t3 = new Thread(() -> {
            Thread.currentThread().setName("第" + 3 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                try {
                    s3.acquire();
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    s1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
