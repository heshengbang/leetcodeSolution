package com.hsb.leetcode.medium;

/*
 * 类描述:
 * Copyright heshengbang
 * @since 2019/7/18 11:41
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

public class String_to_Integer_atoi {
    public static int myAtoi(String str) {
        long result = 0;
        boolean negative = false, isStart = false, getSymbol = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (isStart) {
                    break;
                }
            } else if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || ((str.charAt(i) == '-' || str.charAt(i) == '+') && !getSymbol)) {
                isStart = true;
                getSymbol = true;
                // 负数
                if (str.charAt(i) == '-') {
                    negative = true;
                }
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    result = result * 10 + (str.charAt(i) - '0');

                    long temp = result;
                    if (negative) {
                        temp = 0 - temp;
                    }
                    if (temp > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (temp < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                // 未开始的时候出现非符号和数字字符，返回0
                if (!isStart) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        if (negative) {
            result = 0 - result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
