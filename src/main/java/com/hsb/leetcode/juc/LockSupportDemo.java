package com.hsb.leetcode.juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    private static class DemoThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行了, 中断状态" + Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().getName() + " 将调用LockSupport#park方法");
            long count = 0;
            long a = Long.MAX_VALUE / 1000000000;
            while (count <= a) {
                count++;
            }
            System.out.println(count);
            LockSupport.park();

            System.out.println(Thread.currentThread().getName() + " park造成的阻塞已结束，继续执行 , 中断状态" + Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().getName() + " Hello World");
            System.out.println(Thread.currentThread().getName() + " 结束所有执行");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThread(), "t1");
        t1.start();
        System.out.println("主线程中 " + t1.getName() + " 已经启动");
        System.out.println("主线程中 " + t1.getName() + " 将被unPark");

        Thread.sleep(2000);

        t1.interrupt();


        LockSupport.unpark(t1);
        System.out.println("主线程中 " + t1.getName() + " 已被unPark");
        System.out.println("主线程执行完毕");
    }
}
