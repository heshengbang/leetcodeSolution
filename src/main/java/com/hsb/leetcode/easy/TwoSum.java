package com.hsb.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*
Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            result[0] = i;
            for (int j = i+1; j < nums.length; j++) {
                result[1] = j;
                if (target == (nums[i] + nums[j])) {
                    return result;
                }
            }
        }
        return result;
    }


    public int[] twoSum1(int[] nums, int target) {
        int[] indexMem = new int[nums.length];
//        quickSort(nums, indexMem, 0, nums.length - 1);
        int[] ans = new int[2];


        return nums;

    }

    private void quickSort(int[] nums, int start, int end) {
        int left = start, right = end, key = nums[start];
        while (left < right) {
            while (left < right && key <= nums[right]) {
                right--;
            }
            while (left < right && nums[left] <= key) {
                left++;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = key;
        quickSort(nums, start, left - 1);
        quickSort(nums, right + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
