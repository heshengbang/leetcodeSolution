package com.hsb.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPool {
    private ArrayBlockingQueue<MyWorker> workers;
    private ArrayBlockingQueue<Runnable> tasks;
    private AtomicInteger currentThread;
    private ReentrantLock mainLock;

    private int size;

    public MyThreadPool(int threads) {
        size = threads;
        workers = new ArrayBlockingQueue<>(threads);
        tasks = new ArrayBlockingQueue<>(16);
        currentThread = new AtomicInteger(0);
        mainLock = new ReentrantLock();
    }

    public void submit(Runnable runnable) throws InterruptedException {
        if (currentThread.get() == size) {
            tasks.put(runnable);
            return;
        }
        try {
            mainLock.lock();
            if (currentThread.get() < size) {
                currentThread.getAndIncrement();
                MyWorker myWorker = new MyWorker(runnable);
                workers.put(myWorker);
                myWorker.getThread().start();
                return;
            }
        } finally {
            mainLock.unlock();
        }
    }

    public void shutDown() {
        while (!tasks.isEmpty()) {
            Thread.yield();
        }
        while (!workers.isEmpty()) {
            MyWorker worker = workers.poll();
            worker.isStopped = true;
            worker.thread.interrupt();
        }
    }

    private class MyWorker implements Runnable{
        private Runnable target;
        private Thread thread;
        private volatile boolean isStopped;

        public MyWorker(Runnable runnable) {
            this.target = runnable;
            this.thread = new Thread(this);
            this.isStopped = false;
        }

        public Thread getThread() {
            return this.thread;
        }

        @Override
        public void run() {
            while (!isStopped) {
                if (target != null || (target = getTask()) != null) {
                    target.run();
                    target = null;
                }
                System.out.println(Thread.currentThread().getName() + " isStopped " + isStopped);
            }
            System.out.println(Thread.currentThread().getName() + " isStopped " + isStopped);
        }
    }

    private Runnable getTask() {
        try {
            return tasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static AtomicInteger count = new AtomicInteger(20);
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(3);
        int index = 20;
        while (index-- > 0) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 消费 " + count.getAndDecrement());
                }
            });
        }
        pool.shutDown();
    }

}
