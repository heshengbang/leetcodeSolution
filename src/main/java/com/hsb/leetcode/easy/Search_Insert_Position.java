package com.hsb.leetcode.easy;

/**
 * https://leetcode.com/problems/search-insert-position
 */
public class Search_Insert_Position {
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        return findOrInsert(nums, 0, nums.length - 1, target);
    }

    private int findOrInsert(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else if (nums[start] < target) {
                return start + 1;
            } else {
                return start;
            }
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (target < nums[middle]) {
            return findOrInsert(nums, start, start >= middle ? start : middle - 1, target);
        } else {
            return findOrInsert(nums, middle + 1, end, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;

        Search_Insert_Position it = new Search_Insert_Position();
        System.out.println(it.searchInsert(nums, target));

    }
}
