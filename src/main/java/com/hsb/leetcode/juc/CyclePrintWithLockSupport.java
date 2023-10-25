package com.hsb.leetcode.juc;

import java.util.concurrent.locks.LockSupport;

public class CyclePrintWithLockSupport {
    public static void main(String[] args) {
        PrintThread t4 = new PrintThread("t4");
        PrintThread t3 = new PrintThread("t3");
        PrintThread t2 = new PrintThread("t2");
        PrintThread t1 = new PrintThread("t1");
        t4.setNext(t1);
        t3.setNext(t4);
        t2.setNext(t3);
        t1.setNext(t2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        LockSupport.unpark(t1);
    }

    private static class PrintThread extends Thread {
        private Thread next;

        public PrintThread(String name) {
            setName(name);
        }

        public void setNext(Thread next) {
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println(getName() + " Hello World");
                LockSupport.unpark(next);
            }
        }
    }
}
