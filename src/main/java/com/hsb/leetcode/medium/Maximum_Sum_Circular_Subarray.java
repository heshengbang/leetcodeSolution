package com.hsb.leetcode.medium;

public class Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] startIndex = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
            startIndex[i] = i;
        }
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
                startIndex[i] = startIndex[i - 1];
            }
        }
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (startIndex[length - 1] > 0) {
                    if (dp[length - 1] >= 0) {
                        dp[i] = dp[length - 1] + nums[i];
                        startIndex[i] = startIndex[length - 1];
                    }
                }
                continue;
            }

            if (startIndex[i - 1] != i) {
                if (dp[i - 1] >= 0) {
                    dp[i] = dp[i - 1] + nums[i];
                    startIndex[i] = startIndex[i - 1];
                }
            }
        }
         int result = Integer.MIN_VALUE;
        for (int num: dp) {
            result = Math.max(result, num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};

        Maximum_Sum_Circular_Subarray it = new Maximum_Sum_Circular_Subarray();
        System.out.println(it.maxSubarraySumCircular(nums));
    }
}
