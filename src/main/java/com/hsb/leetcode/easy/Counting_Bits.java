package com.hsb.leetcode.easy;

public class Counting_Bits {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0, 1};
        }
        int[] ans = new int[n + 1];
        int high = 0;
        for (int i = 1 ; i < n + 1; i++) {
            if (is2demi(i)) {
                high = i;
            }
            ans[i] = ans[i - high] + 1;
        }
        return ans;
    }

    private boolean is2demi(int num) {
        return (num & num - 1) == 0;
    }
}
