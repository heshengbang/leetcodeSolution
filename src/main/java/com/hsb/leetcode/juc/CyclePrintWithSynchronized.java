package com.hsb.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CyclePrintWithSynchronized {
    private volatile static int state = 0;
    private static final Object obj = new Object();

    public static void main1(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("第" + 0 + "号线程 ");
                try {
                    for (int i = 0; i < 50; i++) {
                        synchronized (obj) {
                            while (state % 3 != 0) {
                                obj.wait();
                            }
                            System.out.println(Thread.currentThread().getName() + " Hello World");
                            state++;
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("第" + 1 + "号线程 ");
                try {
                    for (int i = 0; i < 50; i++) {
                        synchronized (obj) {
                            while (state % 3 != 1) {
                                obj.wait();
                            }
                            System.out.println(Thread.currentThread().getName() + " Hello World");
                            state++;
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("第" + 2 + "号线程 ");
                try {
                    for (int i = 0; i < 50; i++) {
                        synchronized (obj) {
                            while (state % 3 != 2) {
                                obj.wait();
                            }
                            System.out.println(Thread.currentThread().getName() + " Hello World");
                            state++;
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t0.start();
        t1.start();
        t2.start();
    }


    public static void main(String[] args) throws InterruptedException {
        int n = 3, cycleTime = Integer.MAX_VALUE;
        cyclePrintln(n, cycleTime);
    }

    private static void cyclePrintln(int n, int cycleTime) {
        Object obj = new Object();
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new PrintThread(obj, i, cycleTime));
            t.start();
        }
    }

    static class PrintThread implements Runnable {
        private int cycleTime;
        private int nth;
        private Object obj;

        public PrintThread(Object obj, int nth, int cycleTime) {
            this.obj = obj;
            this.nth = nth;
            this.cycleTime = cycleTime;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("第" + nth + "号线程 ");
            try {
                for (int i = 0; i < cycleTime; i++) {
                    synchronized (obj) {
                        while (state % 3 != nth) {
                            obj.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + " Hello World");
                        state++;
                        obj.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
