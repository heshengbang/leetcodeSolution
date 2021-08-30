package com.hsb.leetcode.easy;

import java.util.Arrays;

public class Move_Zeroes {
    public static void moveZeroes(int[] nums) {
        int index = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                bubbling(nums, i, index);
                index--;
            }
        }
    }

    private static void bubbling(int[] nums, int start, int end) {
        int tmp = nums[start];
        for (int i = start; i < end; i++) {
            nums[i] = nums[i + 1];
        }
        nums[end] = tmp;
    }

    public static void moveZeroes1(int[] nums) {
        for (int l = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] param = {0,1,0,3,12};
        moveZeroes1(param);
        System.out.println(Arrays.toString(param));
    }
}
