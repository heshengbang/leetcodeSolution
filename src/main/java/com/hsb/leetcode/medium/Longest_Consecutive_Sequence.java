package com.hsb.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Longest_Consecutive_Sequence {
    // bad solution
//    public int longestConsecutive(int[] nums) {
//        int length = nums.length;
//        if (length == 0) {
//            return 0;
//        }
//        // dp[i] 表示以nums[i]为最大递增元素的连续元素序列的个数
//        int[] dp = new int[length];
//        // 初始状态，每个元素最少都是自己的连续递增序列，所以是1
//        for (int i = 0; i < length; i++) {
//            dp[i] = 1;
//        }
//        int ans = Integer.MIN_VALUE;
//        for (int i = 1; i < length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] + 1 == nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                    ans = Math.max(ans, dp[i]);
//                }
//            }
//        }
//        return ans == Integer.MIN_VALUE ? 1 : ans;
//    }

    /**
     * bad solution
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num: nums) {
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            boolean[] mem = new boolean[max - min + 1];
            for (int num: nums) {
                mem[num - min] = true;
            }
            int ans = 1;
            int count = 0;
            for (int i = 0; i < mem.length; i++) {
                if (mem[i]) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
            if (count > 0) {
                ans = Math.max(ans, count);
            }
            return ans;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> mem = new TreeSet<>();
        for (int num: nums) {
            mem.add(num);
        }
        int ans = 1;
        int count = 0;
        int pre = Integer.MIN_VALUE;
        while (!mem.isEmpty()) {
            int tmp = mem.pollFirst();
            if (pre != Integer.MIN_VALUE) {
                if (tmp == pre + 1) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            } else {
                count++;
            }
            pre = tmp;
        }
        if (count > 0) {
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Longest_Consecutive_Sequence it = new Longest_Consecutive_Sequence();
        System.out.println(it.longestConsecutive1(nums));
    }
}
