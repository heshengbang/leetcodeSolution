package com.hsb.leetcode.medium;

public class Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE, maxSum = 0, min = Integer.MAX_VALUE, minSum = 0, sum = 0;
        for (int num : nums) {
            maxSum += num;
            max = Math.max(max, maxSum);
            if (maxSum < 0) {
                maxSum = 0;
            }

            minSum += num;
            min = Math.min(min, minSum);
            if (minSum > 0) {
                minSum = 0;
            }
            sum += num;
        }
        if (max < 0) {
            return max;
        } else {
            return Math.max(sum - min, max);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {5, -3, 5};

        int[] nums = {1,-2,3,-2};

//        int[] nums = {-3,-2,-3};

//        int[] nums = {-3, 5 , 2};

//        int[] nums = {2, -2, 2, 7, 8, -1};

        Maximum_Sum_Circular_Subarray it = new Maximum_Sum_Circular_Subarray();
        System.out.println(it.maxSubarraySumCircular(nums));
    }
}
