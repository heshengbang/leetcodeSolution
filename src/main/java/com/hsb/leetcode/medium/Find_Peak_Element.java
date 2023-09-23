package com.hsb.leetcode.medium;

public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        boolean left = false, right = false;
        if (middle == 0 || nums[middle - 1] < nums[middle]) {
            left = true;
        }
        if (middle == nums.length - 1 || nums[middle] > nums[middle + 1]) {
            right = true;
        }
        if (left && right) {
            return middle;
        }
        int result = -1;
        if (middle > 0) {
            result = findPeak(nums, start, middle - 1);
        }
        if (result != -1) {
            return result;
        }
        if (middle + 1 < nums.length) {
            result = findPeak(nums, middle + 1, end);
        }
        return result;
    }
}
