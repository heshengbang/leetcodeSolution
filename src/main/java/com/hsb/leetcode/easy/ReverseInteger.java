package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*
Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {
    private static int reverse(int x) {
        boolean positive = x > 0;
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }
        if (!positive) {
            x = - x;
        }
        String string = String.valueOf(x);
        char[] chars = string.toCharArray();
        int half = (chars.length)/2;
        for (int leftIndex = 0, rightIndex = chars.length - 1; leftIndex < half; leftIndex++, rightIndex--) {
            char swap = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = swap;
        }
        long temp = Long.valueOf(new String(chars));
        if (temp > Integer.MAX_VALUE) {
            return 0;
        }
        x = (int) temp;
        if (!positive) {
            x = - x;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
