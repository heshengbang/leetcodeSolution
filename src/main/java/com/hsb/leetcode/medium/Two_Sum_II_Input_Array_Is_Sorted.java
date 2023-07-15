package com.hsb.leetcode.medium;

import java.util.Arrays;

/**
 *
 * Two Sum II - Input Array Is Sorted
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 *
 *
 */

public class Two_Sum_II_Input_Array_Is_Sorted {


    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int rest = target - numbers[i];
            int index = find(numbers, i + 1, rest);
            if (index != -1) {
                results[0] = i + 1;
                results[1] = index + 1;
                break;
            }
        }
        return results;
    }

    private int find(int[] numbers, int start, int target) {
        if (start > numbers.length - 1) {
            return -1;
        }
        int left = start, right = numbers.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < numbers[middle]) {
                right = middle - 1;
            } else if (target == numbers[middle]) {
                return middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Two_Sum_II_Input_Array_Is_Sorted item = new Two_Sum_II_Input_Array_Is_Sorted();

//        int[] nums = {2,7,11,15};
//        int target = 9;

        int[] nums = {-1,0};
        int target = -1;

        System.out.println(Arrays.toString(item.twoSum(nums, target)));
    }
}
