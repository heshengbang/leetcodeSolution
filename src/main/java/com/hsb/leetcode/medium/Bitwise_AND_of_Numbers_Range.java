package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

public class Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int left, int right) {
        for (int i = 0; i < 32; i++) {
            int fm = 1 << i;
            if (fm > left && right > fm) {
                right = fm;
                break;
            }
        }
        int result = -1;
        for (int i = left; i <= right; i++) {
            result = result & i;
            if (i == Integer.MAX_VALUE) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int left = 1, right = 2147483647;
//        int left = 5, right = 7;
        int left = 2147483646, right = 2147483647;
        Bitwise_AND_of_Numbers_Range it = new Bitwise_AND_of_Numbers_Range();
        System.out.println(it.rangeBitwiseAnd(left, right));
    }
}
