package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/9/24.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 */

public class Contains_Duplicate {
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0 ;i < nums.length; i++) {
            int current = nums[i];
            for (int j = i - 1; j > -1; j--) {
                if (current == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = i < min ? i : min;
            max = i < max ? max : i;
        }
        boolean[] results = new boolean[max - min + 1];
        for (int i : nums) {
            int index = i - min;
            if (results[index]) {
                return true;
            }
            results[index] = true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsDuplicate1(new int[]{1,2,3,4}));
    }
}
