package com.hsb.leetcode.medium;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pivot = findTheRotated(nums, left, right);
        if (pivot == -1) {
            return find(nums, left, right, target);
        } else {
            if (nums[pivot] <= target && target <= nums[right]) {
                return find(nums, pivot, right, target);
            } else if (nums[left] <= target && pivot > 0 && target <= nums[pivot - 1]) {
                return find(nums, left, pivot - 1, target);
            } else {
                return -1;
            }
        }
    }

    private int find(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return find(nums, middle + 1, right, target);
        }  else {
            return find(nums, left, middle - 1, target);
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
        Search_in_Rotated_Sorted_Array it = new Search_in_Rotated_Sorted_Array();
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;

        int[] nums = {1};
        int target = 1;


        System.out.println(it.search(nums, target));
    }
}
