package com.hsb.leetcode.had;

import java.util.Arrays;
import java.util.BitSet;

public class Reverse_Pairs {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length;j++) {
                if (nums[i] > (long)2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(2,8, true);
        System.out.println(Arrays.toString(bitSet.toByteArray()));
    }
}
