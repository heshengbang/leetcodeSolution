package com.hsb.leetcode.medium;

import java.util.Arrays;

public class Next_Permutation {
    public static void main(String[] args) {
        int[] param = {1,1,5};
        nextPermutation(param);
        System.out.println(Arrays.toString(param));
    }


    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int select = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                select = i;
                break;
            }
        }
        int tmp = nums[index];
        nums[index] = nums[select];
        nums[select] = tmp;
        reverse(nums, index + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
