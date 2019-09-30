package com.hsb.leetcode.easy;

/**
 * 类描述:
 * Copyright
 *
 * @author heshengbang
 * @version 1.0
 * @since 2019/9/30 18:57
 */

/**
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 */
public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        for (; n > 1; n = n/2) {
            if (n % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Power_of_Two item = new Power_of_Two();
        System.out.println(item.isPowerOfTwo(28));
    }
}
