package com.hsb.leetcode.medium;

public class House_Robber {
    /**
     *
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
     *  and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     * 初始状态，如果没有房子，则价值为0，如果只有一个房子则价值就是房子的金额，如果有两个房子，则挑选价值打的打劫
     *
     * 状态参数，房子的数量，随着房子的数量增多，打劫金额会增多
     *
     * 假设备忘录为dp[n]，那么dp[i]就代表打劫到i户商户能抢劫到的最大金额
     *
     * 比较dp[i - 1] 和 dp[i - 2] + nums[i]的价值，决策取最大的那个值
     *
     * 状态转移方程：dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     *
     * dp[i]只依赖dp[i - 1]和dp[i - 2]，这将是一个空间优化的方向
     *
     * @param nums 每个房子的金额
     * @return 最大金额数量
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length + 1];
//        int[] status = new int[length + 1];
        dp[0] = 0;
//        status[0] = 0;
        dp[1] = nums[0];
//        status[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
//        status[2] = nums[1];

        for (int i = 3; i < length + 1; i++) {
//            status[i] = status[i - 2] + nums[i - 1];
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};
        House_Robber it = new House_Robber();
        System.out.println(it.rob(nums));
    }
}
