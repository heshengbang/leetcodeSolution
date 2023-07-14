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

https://leetcode.com/problems/longest-common-prefix

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

    public String longestCommonPrefix1(String[] strs) {
        StringBuffer sb = new StringBuffer();
        sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            for ( int j = 0; j < strs[i].length(); j++) {
                if (sb.length() <= j) {
                    break;
                }
                if (sb.charAt(j) == strs[i].charAt(j)) {
                    continue;
                } else {
                    sb = sb.delete(j, sb.length());
                }
            }
            if (strs[i].length() < sb.length()) {
                sb.delete(strs[i].length(), sb.length());
            }
        }
        return sb.toString();
    }

//    public String longestCommonPrefix2(String[] strs) {
//        int[][] map = new int[strs.length][200];
//        for (int i = 0; i < )
//
//
//
//
//
//
//    }

    public static void main(String[] args) {
//        String[] strings = {"flower","flow","flight"};
//        System.out.println(longestCommonPrefix(strings));

//        String[] strings = {"ab", "a"};
        String[] strings = {"dog","racecar","car"};

        LongestCommonPrefix item = new LongestCommonPrefix();
        System.out.println(item.longestCommonPrefix1(strings));
    }
}
