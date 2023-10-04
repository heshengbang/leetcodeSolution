package com.hsb.leetcode.medium;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int[] result = find(nums, left, right, target);
        if (result == null) {
            return new int[]{-1, -1};
        } else {
            return result;
        }
    }

    private int[] find(int[] nums, int left, int right, int target) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            int[] result = new int[2];
            int index = middle;
            while (index >= left) {
                if (nums[index] == target) {
                    result[0] = index;
                    index--;
                } else {
                    break;
                }
            }
            index = middle;
            while (index <= right) {
                if (nums[index] == target) {
                    result[1] = index;
                    index++;
                } else {
                    break;
                }
            }
            return result;
        } else if (nums[middle] < target) {
            return find(nums, middle + 1, right, target);
        } else {
            return find(nums, left, middle - 1, target);
        }
    }

    public static void main(String[] args) {
        Find_First_and_Last_Position_of_Element_in_Sorted_Array it = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(it.searchRange(nums, target));
    }
}
