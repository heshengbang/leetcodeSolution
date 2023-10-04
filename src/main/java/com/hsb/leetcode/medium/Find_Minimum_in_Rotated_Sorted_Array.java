package com.hsb.leetcode.medium;

public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int result = findTheRotated(nums, left, right);
        if (result == -1) {
            return nums[0];
        } else {
            return nums[result];
        }
    }

    private int findTheRotated(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (middle > 0 && nums[middle - 1] > nums[middle]) {
            return middle;
        }
        if (middle + 1 < nums.length && nums[middle] > nums[middle + 1]) {
            return middle + 1;
        }
        int result = findTheRotated(nums, left, middle - 1);
        if (result == -1) {
            result = findTheRotated(nums, middle + 1, right);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        Find_Minimum_in_Rotated_Sorted_Array it = new Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(it.findMin(nums));
    }
}
