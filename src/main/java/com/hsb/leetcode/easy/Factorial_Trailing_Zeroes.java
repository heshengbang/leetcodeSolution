package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/28 9:16
 *
 * @author heshengbang
 */

public class Factorial_Trailing_Zeroes {

    public static int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += (n /= 5);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
}
