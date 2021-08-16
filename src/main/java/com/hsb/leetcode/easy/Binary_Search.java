package com.hsb.leetcode.easy;

public class Binary_Search {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        int index = (left + right) / 2;
        while (index >= left && index <= right) {
            if (nums[index] == target) {
                return index;
            } else if (target < nums[index]) {
                right = index - 1;
                index = (left + right) / 2;
            } else {
                left = index + 1;
                index = (left + right) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 10));
    }
}
