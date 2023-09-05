package com.hsb.leetcode.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        scene1();
    }

    // 场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行
    public static void scene1() {
        // 模块计数器，每一个模块准备好的时候就倒计数一次
        CountDownLatch moduleCountDown = new CountDownLatch(3);
        // 并发计数器，测试最大并发量，确保三个模块是同时开始的
        CountDownLatch concurrentThreadCount = new CountDownLatch(1);
        final boolean[] module = {false, false, false};

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 在并发计数器上等待
                    concurrentThreadCount.await();
                    // 表示业务上的组装模块
                    module[0] = true;
                    // 当前模块组装完毕，倒计数一次
                    moduleCountDown.countDown();
                    System.out.println("Module1 is ready! ");
                } catch (InterruptedException e) {
                    System.out.println("Module1 have problem");
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    concurrentThreadCount.await();
                    module[1] = true;
                    moduleCountDown.countDown();
                    System.out.println("Module2 is ready! ");
                } catch (InterruptedException e) {
                    System.out.println("Module2 have problem");
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    concurrentThreadCount.await();
                    module[2] = true;
                    moduleCountDown.countDown();
                    System.out.println("Module3 is ready! ");
                } catch (InterruptedException e) {
                    System.out.println("Module3 have problem");
                }
            }
        });

        try {
            System.out.println("scene1 is waiting for modules ready...");
            // 启动模块组装线程
            t1.start();
            t2.start();
            t3.start();
            System.out.println("all modules is running...");
            // 主线程休眠1s，确保模块线程都阻塞在CountDownLatch#await
            Thread.sleep(1000);
            // 并发计数器倒计数一次，此时所有await的模块线程会同时启动
            concurrentThreadCount.countDown();
            // 阻塞在模块计数器的主线程，所有模块计数器完成以后才能继续执行
            moduleCountDown.await();
            // 验证所有模块线程已经执行完毕
            if (module[0] && module[1] && module[2]) {
                System.out.println("scene1 is starting! ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
