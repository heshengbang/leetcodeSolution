package com.hsb.leetcode.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CyclePrint {
    public static void main(String[] args) throws InterruptedException {
        int n = 5, cycleTime = 50;
        cyclePrintln(n, cycleTime);
    }

    private static void cyclePrintln(int n, int cycleTime) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new PrintThread(lock, i, condition, cycleTime));
            t.start();
        }
    }

    static class PrintThread implements Runnable {
        private ReentrantLock lock;
        private Condition condition;
        private int cycleTime;
        private int nth;
        private int printTime;

        public PrintThread(ReentrantLock lock, int nth, Condition condition, int cycleTime) {
            this.lock = lock;
            this.condition = condition;
            this.nth = nth;
            this.cycleTime = cycleTime;
            this.printTime = 0;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("第" + nth + "号线程 ");
            try {
                Thread.sleep(1000);
                lock.lock();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " Hello World " + printTime);
                    printTime++;
                    condition.signal();
                    if (printTime < cycleTime) {
                        condition.await();
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
