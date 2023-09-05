package com.hsb.leetcode.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample {

    /**
     * 消费者
     * 最多只能消费指定的产品个数
     */
    private static class ConsumeWorker implements Runnable {
        private int[] warehouse;

        private int maxConsumeCount;

        private int consumeCount;

        private Condition isFull;

        private Condition isEmpty;

        private ReentrantLock lock;

        public ConsumeWorker(Condition isFull, Condition isEmpty, ReentrantLock lock, int[] warehouse, int maxConsumeCount) {
            this.warehouse = warehouse;
            this.maxConsumeCount = maxConsumeCount;
            this.isFull = isFull;
            this.isEmpty = isEmpty;
            this.lock = lock;
            consumeCount = 0;
        }

        @Override
        public void run() {
            while (consumeCount < maxConsumeCount) {
                try {
                    lock.lock();
                    if (index == 0) {
                        try {
                            System.out.println("当前在isFull上等待的线程数：" + lock.getWaitQueueLength(isFull));
                            System.out.println("当前在isEmpty上等待的线程数：" + lock.getWaitQueueLength(isEmpty));
                            System.out.println("当前在lock上等待的线程数：" + lock.getQueueLength());

                            System.out.println(Thread.currentThread().getName() + " no product provide ");
                            // 没有产品可消费了，所以进入等待
                            isEmpty.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        index--;
                        System.out.println(Thread.currentThread().getName() + " has consumed " + warehouse[index]);
                        consumeCount++;
                        // 消费后表示仓库有空间，可以唤醒在  满  这个条件上等待的线程去生产
                        isFull.signalAll();
                    }
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + " has finish consume job ");

        }
    }


    private static class ProduceWorker implements Runnable {

        public ProduceWorker(Condition isFull, Condition isEmpty, ReentrantLock lock, int[] warehouse, int maxProduceCount) {
            this.warehouse = warehouse;
            this.maxProduceCount = maxProduceCount;
            this.isFull = isFull;
            this.isEmpty = isEmpty;
            this.lock = lock;
            produceCount = 0;
        }

        private int[] warehouse;

        private int maxProduceCount;

        private int produceCount;

        private Condition isFull;

        private Condition isEmpty;

        private ReentrantLock lock;

        @Override
        public void run() {

            while (produceCount < maxProduceCount) {
                try {
                    lock.lock();
                    if (index == warehouse.length) {
                        // 仓库已满，不能再生产，否则爆仓
                        try {
                            System.out.println(Thread.currentThread().getName() + " warehouse has full ");
                            isFull.await();
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + " produce has exception ");
                            throw new RuntimeException(e);
                        }
                    } else {
                        Random random = new Random();
                        warehouse[index] = random.nextInt(100);
                        System.out.println(Thread.currentThread().getName() + " produce product " + warehouse[index]);
                        produceCount++;
                        index++;
                        // 生产产品以后，唤醒在  空  上面等待的生产者线程
                        isEmpty.signalAll();
                    }
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getName() + " has finish produce job ");
        }
    }


    private static volatile int index;

    public static void main(String[] args) {
        int[] warehouse = new int[5];
        ReentrantLock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        // 创建3个消费者线程，每个线程要完成20个消费产品的任务
        for (int i = 0; i < 3; i++) {
            new Thread(new ConsumeWorker(isFull, isEmpty, lock, warehouse, 1000)).start();
        }
        // 创建3个生产者线程，每个线程要完成20个生产产品的任务
        for (int i = 0; i < 3; i++) {
            new Thread(new ProduceWorker(isFull, isEmpty, lock, warehouse, 1000)).start();
        }
    }
}
