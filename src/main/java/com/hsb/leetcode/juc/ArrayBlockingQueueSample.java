package com.hsb.leetcode.juc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayBlockingQueueSample {

    private static class ProduceWorker implements Runnable {
        private BlockingQueue<Integer> queue;
        private int maxProduceCount;
        private int produceCount;
        private CountDownLatch latch;

        public ProduceWorker(BlockingQueue<Integer> queue, int maxProduceCount, CountDownLatch latch) {
            this.queue = queue;
            this.maxProduceCount = maxProduceCount;
            this.latch = latch;
            produceCount = 0;
        }

        @Override
        public void run() {
            while (produceCount < maxProduceCount) {
                try {
                    Random random = new Random();
                    int product = random.nextInt(100);
                    queue.put(product);
                    totalProduceCount.getAndIncrement();
                    produceCount++;
                    System.out.println(Thread.currentThread().getName() + " produce product " + product);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " produce has exception ");
                    throw new RuntimeException(e);
                }
            }
            latch.countDown();
        }
    }

    private static class ConsumeWorker implements Runnable {
        private BlockingQueue<Integer> queue;
        private int maxConsumeCount;
        private int consumeCount;
        private CountDownLatch latch;

        public ConsumeWorker(BlockingQueue<Integer> queue, int maxConsumeCount, CountDownLatch latch) {
            this.queue = queue;
            this.maxConsumeCount = maxConsumeCount;
            this.latch = latch;
            consumeCount = 0;
        }

        @Override
        public void run() {
            while (consumeCount < maxConsumeCount) {
                try {
                    Integer product = queue.take();
                    System.out.println(Thread.currentThread().getName() + " consume product " + product);
                    consumeCount++;
                    totalConsumeCount.getAndIncrement();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " consume has exception ");
                    throw new RuntimeException(e);
                }
            }
            latch.countDown();
        }
    }

    private static AtomicInteger totalProduceCount;
    private static AtomicInteger totalConsumeCount;

    public static void main(String[] args) {
        totalConsumeCount = new AtomicInteger();
        totalProduceCount = new AtomicInteger();

        CountDownLatch latch = new CountDownLatch(6);

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 3; i++) {
            new Thread(new ConsumeWorker(queue, 100, latch)).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new ProduceWorker(queue, 100, latch)).start();
        }

        try {
            latch.await();
            if (totalConsumeCount.get() == totalProduceCount.get()) {
                System.out.println("生产者生产的全部产品都被消费了，产品数量都是：" + totalConsumeCount.get());
            } else {
                System.out.println("生产者生产的产品和消费者消费的产品不一致，生产产品为：" + totalProduceCount.get() + " 消费产品：" + totalConsumeCount.get());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " compare has exception ");
            throw new RuntimeException(e);
        }
    }
}
