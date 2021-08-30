package com.hsb.leetcode.easy;

import java.util.Arrays;

public class Shuffle_the_Array {

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n;i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }

    public static int[] shuffleInPlace(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n;i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7,8};
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }
}
