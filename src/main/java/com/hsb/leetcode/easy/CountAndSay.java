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
Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

 */

public class CountAndSay {
    private static String recursiveCountAndSay(String str) {
        if (str.length() == 0) {
            return "";
        } else if (str.length() == 1) {
            return "1" + str;
        }
        char[] chars = str.toCharArray();
        char curChar = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (curChar != aChar) {
                if (count != 0) {
                    result.append(count).append(curChar);
                }
                curChar = aChar;
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 0) {
            result.append(count).append(curChar);
        }
        return result.toString();
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String temp = countAndSay(n -1);
            return recursiveCountAndSay(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }
}
