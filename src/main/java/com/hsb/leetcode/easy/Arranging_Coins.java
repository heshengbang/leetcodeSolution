package com.hsb.leetcode.easy;

public class Arranging_Coins {
    public static int arrangeCoins(int n) {
        int index = 1;
        while (true) {
            n = n - index;
            if (n < 0) {
                return index - 1;
            } else if (n == 0) {
                return index;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(Integer.MAX_VALUE));
    }
}
