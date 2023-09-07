package com.hsb.leetcode.medium;

import java.util.Arrays;

/**
 *
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 */
public class Longest_Increasing_Subsequence {
    /**
     * 最简单的严格递增序列就是一个元素的序列，长度为1
     *
     * 此处状态参数取数组索引，那么每个位置的最短长度都是1，此即初始化状态
     *
     * 设置状态备忘录 dp[i] 表示nums的0 ~ i位置的子数组中最长严格递增序列的长度
     *
     * 状态转移方程 dp[i] = Max(dp[j]) + 1, nums[j] < nums[i], j < i
     *
     * @param nums 给定的数组
     * @return 最长严格递增序列的个数
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        // 初始状态，每个位置，哪怕数组前面所有数字都大于当前数字，那当前数字也是递增序列的第一个
        Arrays.fill(dp, 1);
        int ans = 1;
        // 从1开始，因为0位置的最长递增序列永远是1
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};

        Longest_Increasing_Subsequence it = new Longest_Increasing_Subsequence();
        System.out.println(it.lengthOfLIS(nums));
    }
}
