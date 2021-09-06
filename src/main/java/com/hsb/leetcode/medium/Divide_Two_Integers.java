package com.hsb.leetcode.medium;

public class Divide_Two_Integers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            result++;
        }
        if (divisor == Integer.MIN_VALUE) {
            return result;
        }

        boolean negative = (dividend ^ divisor) >>> 31 == 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int index = 1;
            int count = 1;
            while (dividend >= (long) index * divisor) {
                index = index << 1;
                count++;
                if (count == 31) {
                    break;
                }
            }
            index = index >> 1;
            dividend = dividend - index * divisor;
            result += index;
        }
        if (negative) {
            return -result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        // 1100540749
        //-1090366779
        System.out.println(divide(1100540749, -1090366779));
        // -1010369383
        //-2147483648
        System.out.println(divide(1010369383, -2147483648));
        // -2147483648
        //1
        System.out.println(divide(-2147483648, 1));
        // 2147483647
        //1
        System.out.println(divide(2147483647, 1));
    }
}
