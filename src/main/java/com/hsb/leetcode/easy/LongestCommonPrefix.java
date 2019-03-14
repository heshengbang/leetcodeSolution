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
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        int minLength = 0;
        for (String item: strs) {
            if (item.length() == 0) {
                return "";
            }
            if (item.length() < minLength || minLength == 0) {
                minLength = item.length();
            }
        }
        char ch;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< minLength; i++) {
            ch = strs[0].charAt(i);
            for (String item: strs) {
                if (item.charAt(i) != ch) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }
}
