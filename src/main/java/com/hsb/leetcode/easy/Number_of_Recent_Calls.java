package com.hsb.leetcode.easy;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Number_of_Recent_Calls {
    static class RecentCounter {
        private LinkedList<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            if (queue.isEmpty()) {
                queue.addLast(t);
            } else {
                while (!queue.isEmpty() && queue.getFirst() + 3000 < t) {
                    queue.removeFirst();
                }
                queue.addLast(t);
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter it = new RecentCounter();
        System.out.println(it.ping(1));
        System.out.println(it.ping(100));
        System.out.println(it.ping(3001));
        System.out.println(it.ping(3002));
    }
}
