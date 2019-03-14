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
Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.

 */

public class Sqrt_x {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int i = 1, j = x;
        while (i < j) {
            long mid = i + (j - i) / 2;
            if (mid * mid < x) {
                i = (int) mid + 1;
            } else {
                j = (int) mid;
            }
        }
        return i * i == x ? i : i - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}
