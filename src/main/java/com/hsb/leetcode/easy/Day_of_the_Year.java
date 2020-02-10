package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/2/8 14:04
 */

public class Day_of_the_Year {
    public int dayOfYear(String date) {
        String[] array = date.split("-");
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        if (month == 1) {
            return day;
        } else if (month == 2) {
            return 31 + day;
        }
        int second;
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                second = 29;
            } else {
                second = 28;
            }
        } else {
            if (year % 4 == 0) {
                second = 29;
            } else {
                second = 28;
            }
        }
        if (month == 3) {
            return 31 + second + day;
        } else if (month == 4) {
            return 31 + second + 31 + day;
        } else if (month == 5) {
            return 31 + second + 31 + 30 + day;
        } else if (month == 6) {
            return 31 + second + 31 + 30 + 31 + day;
        } else if (month == 7) {
            return 31 + second + 31 + 30 + 31 + 30 + day;
        } else if (month == 8) {
            return 31 + second + 31 + 30 + 31 + 30 + 31 + day;
        } else if (month == 9) {
            return 31 + second + 31 + 30 + 31 + 30 + 31 + 31 + day;
        } else if (month == 10) {
            return 31 + second + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
        } else if (month == 11) {
            return 31 + second + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
        } else if (month == 12) {
            return 31 + second + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
        }
        return 0;
    }

    public static void main(String[] args) {
        Day_of_the_Year item = new Day_of_the_Year();
        System.out.println(item.dayOfYear("2004-03-01"));
    }
}
