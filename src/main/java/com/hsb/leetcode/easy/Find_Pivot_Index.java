package com.hsb.leetcode.easy;

/*
 * 类描述:
 *
 * @author heshengbang
 * @version 1.0
 * @since 2019/9/30 22:23
 */

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 *
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 *
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Note:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 *
 *
 *
 */
public class Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int sumAll = 0;
        for (int item: nums) {
            sumAll += item;
        }
        int sumCurrent = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                sumCurrent += nums[i - 1];
            }
            if (sumCurrent == (sumAll - sumCurrent - nums[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testCase = new int[]{-1,-1,0,1,1,0};
        Find_Pivot_Index item = new Find_Pivot_Index();
        System.out.println(item.pivotIndex(testCase));
    }
}
