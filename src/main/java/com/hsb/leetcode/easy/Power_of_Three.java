package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2020/1/6 22:04
 * @version 1.0
 */

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Power_of_Three {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        long n = 1;
        while (n < Integer.MAX_VALUE) {
            n *= 3;
        }
        System.out.println(n / 3);
    }
}
