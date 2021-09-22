package com.hsb.leetcode.medium;

import java.util.Arrays;

public class Rotate_Array {
    public static void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            return;
        }
        int rotate = k % nums.length;
        if (rotate == 0) {
            return;
        }
        int[] map = new int[nums.length * 2];
        for (int i = 0; i < nums.length;i++) {
            map[i] = nums[i];
            map[i + nums.length] = nums[i];
        }
        int start = nums.length - rotate;
        int end = nums.length * 2 - rotate;

        for (int i = start, j = 0; i < end; i++, j++) {
            nums[j] = map[i];
        }
    }

    public static void main(String[] args) {
        int[] param = {1, 2};
        rotate(param, 3);
        System.out.println(Arrays.toString(param));
    }
}
