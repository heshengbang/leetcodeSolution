package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] mem = new int[max - min];

        for (int num: nums) {
            mem[num - min]++;
        }
        int i = mem.length - 1;
        while (i >= 0) {
            k = k - mem[i];
            if (k <= 0) {
                return min + i;
            }
            i--;
        }
        return -1;
    }
}
