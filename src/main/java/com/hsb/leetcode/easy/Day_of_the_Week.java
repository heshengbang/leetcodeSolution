package com.hsb.leetcode.easy;

/*
 * @author heshengbang
 * 2019/9/29.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 *
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 *
 *
 * Constraints:
 *
 * The given dates are valid dates between the years 1971 and 2100.
 *
 */
public class Day_of_the_Week {
    public String dayOfTheWeek(int day, int month, int year) {
        String zhouyi = "Monday";
        String zhouer = "Tuesday";
        String zhousan = "Wednesday";
        String zhousi = "Thursday";
        String zhouwu = "Friday";
        String zhouliu = "Saturday";
        String zhouri = "Sunday";

        int number = 0;
        for (int i = 1970; i < year;i++) {
            number = number + isLeapYear(i) + 365;
        }
        if (month == 1) {
            number = number + day;
        } else if (month == 2) {
            number = number + 31 + day;
        } else if (month == 3) {
            number = number + 31 + day + 28 + isLeapYear(year);
        }  else if (month == 4) {
            number = number + 31 * 2 + day + 28 + isLeapYear(year);
        }  else if (month == 5) {
            number = number + 31 * 2 + day + 28 + isLeapYear(year) + 30;
        }  else if (month == 6) {
            number = number + 31 * 3 + day + 28 + isLeapYear(year) + 30;
        }  else if (month == 7) {
            number = number + 31 * 3 + day + 28 + isLeapYear(year) + 30 * 2;
        }  else if (month == 8) {
            number = number + 31 * 4 + day + 28 + isLeapYear(year) + 30 * 2;
        }  else if (month == 9) {
            number = number + 31 * 5 + day + 28 + isLeapYear(year) + 30 * 2;
        }  else if (month == 10) {
            number = number + 31 * 5 + day + 28 + isLeapYear(year) + 30 * 3;
        }  else if (month == 11) {
            number = number + 31 * 6 + day + 28 + isLeapYear(year) + 30 * 3;
        }  else if (month == 12) {
            number = number + 31 * 6 + day + 28 + isLeapYear(year) + 30 * 4;
        }
        number --;
        if (number % 7 == 0) {
            return zhousi;
        } else if (number % 7 == 1) {
            return zhouwu;
        } else if (number % 7 == 2) {
            return zhouliu;
        } else if (number % 7 == 3) {
            return zhouri;
        } else if (number % 7 == 4) {
            return zhouyi;
        } else if (number % 7 == 5) {
            return zhouer;
        } else if (number % 7 == 6) {
            return zhousan;
        }
        return "";
    }
    private int isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return 1;
        }
        if (year % 400 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Day_of_the_Week item = new Day_of_the_Week();
        System.out.println(item.dayOfTheWeek(29, 9,2019));
    }


}
