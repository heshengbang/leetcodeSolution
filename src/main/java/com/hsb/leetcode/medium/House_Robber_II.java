package com.hsb.leetcode.medium;

/*
 * @since 2020/1/17 23:29
 * @version 1.0
 *************************************************
 */

public class House_Robber_II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        int containHead = dp[nums.length - 1];
        dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int containLast = dp[nums.length - 1];
        return Math.max(containHead, containLast);
    }

    public static void main(String[] args) {
        House_Robber_II item = new House_Robber_II();
        int[] params = {3, 2, 5};
        System.out.println(item.rob(params));
    }
}
