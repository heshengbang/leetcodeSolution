package com.hsb.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CyclePrintWithLockAndCondition {
    private volatile static int state = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("第" + 1 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 0) {
                        c1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    state++;
                    c2.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        });

        Thread t2 = new Thread(() -> {
            Thread.currentThread().setName("第" + 2 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 1) {
                        c2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    state++;
                    c3.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        });

        Thread t3 = new Thread(() -> {
            Thread.currentThread().setName("第" + 3 + "号线程 ");
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 2) {
                        c3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " Hello World ");
                    state++;
                    c1.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        });
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main1(String[] args) throws InterruptedException {
        int n = 5, cycleTime = 50;
        cyclePrintln(n, cycleTime);
    }

    private static void cyclePrintln(int n, int cycleTime) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new PrintThread(lock, condition, i, n, cycleTime));
            t.start();
        }
    }

    static class PrintThread implements Runnable {
        private ReentrantLock lock;
        private Condition condition;
        private int cycleTime;
        private int nth;
        private int mod;
        private int printTime;

        public PrintThread(ReentrantLock lock, Condition condition, int nth, int mod, int cycleTime) {
            this.lock = lock;
            this.condition = condition;
            this.nth = nth;
            this.cycleTime = cycleTime;
            this.mod = mod;
            this.printTime = 0;
        }

        @Override
        public void run() {

            Thread.currentThread().setName("第" + nth + "号线程 ");
            for (int i = 0; i < cycleTime; i++) {
                lock.lock();
                try {
                    // 如果不是当前线程，则继续在条件上等待
                    while (state % mod != nth) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " Hello World " + printTime);
                    state++;
                    printTime++;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
