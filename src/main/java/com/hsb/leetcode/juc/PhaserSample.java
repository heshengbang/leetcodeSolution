package com.hsb.leetcode.juc;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Phaser;



public class PhaserSample {
    public static void main(String[] args) throws InterruptedException {
        scene1();
        scene2();
    }

    /**
     * 假设有16个队伍要比拼技能
     *
     * 按照16个队伍，16进8，8进4，4进2，2进1的方式进行。
     *
     */
    static int[] score = new int[16];
    static boolean[] hasRead = new boolean[16];
    private static void scene2() {
        Phaser phaser = new Phaser(16);
        // 启动16支队伍
        for (int i = 0; i < 16; i++) {
            new Thread(new PhaserCompetition(i, phaser)).start();;
        }
        int num = 16;
        while (num > 1) {
            Arrays.sort(score);
            // 淘汰一半的队伍，淘汰的队伍分数置为-1
            for (int i = 0; i < num / 2; i++) {
                score[i] = -1;
            }
            for (int i = num / 2; i < num; i++) {
                hasRead[i] = true;
            }
            // 缩减一半的队伍
            num = num / 2;
        }
        System.out.println("Has Finished Competition! The winner is ");
    }

    private static class PhaserCompetition implements Runnable {
        private int num;
        private Phaser phaser;
        public PhaserCompetition(int num, Phaser phaser) {
            this.num = num;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            while (true) {
                if (score[num] != -1) {
                    // 数据还没读的时候不进入下一轮比赛
                    while (!hasRead[num]) {}
                    // 这一轮比赛的分数
                    Random random = new Random();
                    score[num] = random.nextInt(100);
                    // 等待其他队伍完成
                    phaser.arriveAndAwaitAdvance();
                    // 等待数据读取
                    hasRead[num] = false;
                } else {
                    // 如果上一次的分数记录被置为-1，则表明该队伍被淘汰，所以phaser需要deregister
                    phaser.arriveAndDeregister();
                    // 跳出比赛循环，结束当前线程
                    break;
                }
            }
        }
    }



    /**
     * 假定有16个任务需要去完成，在完成这一阶段任务以后才能开始下一阶段任务，任务之间没有依赖关系，所以可以多线程并发去执行任务，不过执行完以后需要等待其他任务结束。
     * @throws InterruptedException
     */
    static boolean[] jobs = new boolean[16];
    private static void scene1() throws InterruptedException {
        Phaser phaser = new Phaser(16);
        for (int i = 0; i < 16; i++) {
            new Thread(new PhaserWorker(i, phaser)).start();
        }
        Thread.sleep(1000);
        boolean result = true;
        for (boolean it: jobs) {
            result = result && it;
        }
        if (result) {
            System.out.println(Thread.currentThread().getName() + " Job finish well!");
        } else {
            System.out.println(Thread.currentThread().getName() + " Job finish badly");
        }
    }


    private static class PhaserWorker implements Runnable {
        private int i;
        private Phaser phaser;
        public PhaserWorker(int i, Phaser phaser) {
            this.i = i;
            this.phaser = phaser;
        }


        @Override
        public void run() {
            jobs[i] = true;
            System.out.println(Thread.currentThread().getName() + " has finish work, will wait for other thread finish");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
