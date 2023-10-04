package com.hsb.leetcode.medium;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // dp[i] 代表以nums[i]为最右侧元素的子数组的最大和
        int[] dp = new int[length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
            result = Math.max(result, dp[i]);
        }
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

//        int[] nums = {1};

//        int[] nums = {5,4,-1,7,8};

        int[] nums = {-5};


        Maximum_Subarray it = new Maximum_Subarray();
        System.out.println(it.maxSubArray(nums));
    }
}
