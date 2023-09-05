package com.hsb.leetcode.juc;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    private static int data = 0;

    public static void main(String[] args) {
        // 每四个数据一批发送
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " send total " + data);
                data = 0;
            }
        });
        dataGenerator(barrier);
    }

    private static void dataGenerator(CyclicBarrier barrier) {
        for (int i = 0; i < 4; i ++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1; j++) {
                    // 获得数据
                    Random random = new Random();
                    int tmp = random.nextInt(100);
                    System.out.println("Current " + Thread.currentThread().getName() + " will wait on CyclicBarrier, and generate data " + tmp);
                    data += tmp;
                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
    }


    public static void main1(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Action...GO again!"));
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier barrier;

        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Executed!");
                    barrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}