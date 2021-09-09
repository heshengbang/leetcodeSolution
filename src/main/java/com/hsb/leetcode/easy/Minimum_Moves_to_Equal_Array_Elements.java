package com.hsb.leetcode.easy;


public class Minimum_Moves_to_Equal_Array_Elements {
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            min = Math.min(num, min);
        }
        int res = 0;
        for (int num: nums) {
            res += num - min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(minMoves(nums));
    }
}
