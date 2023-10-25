package com.hsb.leetcode;

public class Test {

    private static class AddThread extends Thread {
        public void run() {
            for (int i = 0; i < 40000; i++) Test.sum += 1;
        }
    }

    public static volatile int sum = 0;

    public static void main(String[] args) throws Exception {
        AddThread t1 = new AddThread();
        AddThread t2 = new AddThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sum);
    }
}
