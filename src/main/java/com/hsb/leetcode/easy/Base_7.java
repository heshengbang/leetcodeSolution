package com.hsb.leetcode.easy;

public class Base_7 {
    public static String convertToBase7(int num) {
        int result = 0;
        int multiple = 1;
        while (num != 0) {
            int rest = num % 7;
            result = result + rest * multiple;
            multiple = 10 * multiple;
            num = num / 7;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
}
