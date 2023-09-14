package com.hsb.leetcode.easy;

import java.util.Arrays;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*
Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */

public class PlusOne {
    public static int[] plusOne1(int[] digits) {
        int length = digits.length;
        int plusOne = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (plusOne != 0) {
                int tmp = digits[i] + plusOne;
                if (tmp >= 10) {
                    digits[i] = tmp % 10;
                    plusOne = tmp / 10;
                } else {
                    plusOne = 0;
                    digits[i] = tmp;
                    return digits;
                }
            }
        }
        if (plusOne > 0) {
            int[] result = new int[length + 1];
            result[0] = plusOne;
            for (int i = 1; i <= length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int temp = digits[i] + one;
            if (temp > 9) {
                digits[i] = temp % 10;
            } else {
                digits[i] = temp;
                return digits;
            }
        }
        int[] results = new int[digits.length + 1];
        results[0] = 1;
        System.arraycopy(digits, 0, results, 1, digits.length);
        return results;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
