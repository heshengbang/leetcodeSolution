package com.hsb.leetcode.medium;

/**
 * Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * https://leetcode.com/problems/minimum-size-subarray-sum
 */

public class Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {

        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] >= target) {
                result = Math.min(i, result);
            }
            sums[i] -= nums[i];
            if (i + 1 < nums.length) {
                sums[i] += nums[i + 1];
            }
        }
        return 0;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (left < nums.length && right < nums.length) {
            while (sum < target && right < nums.length) {
                sum += nums[right++];
            }
            while (sum >= target && left <= right) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;

        int[] nums = {1, 4, 5};
        int target = 4;

//        int[] nums = {1,1,1,1,1,1,1,1};
//        int target = 11;

//        int[] nums = {1,2,3,4,5};
//        int target = 11;

//        int[] nums = {1,2,3,4,5};
//        int target = 15;


        Minimum_Size_Subarray_Sum item = new Minimum_Size_Subarray_Sum();
        System.out.println(item.minSubArrayLen2(target, nums));
    }
}
