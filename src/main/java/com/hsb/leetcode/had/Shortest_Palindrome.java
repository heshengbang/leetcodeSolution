package com.hsb.leetcode.had;

/*
 * 类描述:
 * Copyright trulyheshengbang@gmail.com
 * @since 2019/7/9 18:10
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

/**
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 */

public class Shortest_Palindrome {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int index = findPalindrome(s);
        String temp = s.substring(index);
        StringBuilder sb = new StringBuilder(temp);
        return sb.reverse().append(s).toString();
    }

    private static int findPalindrome(String s) {
        int i = 0, right, left, length = 1;
        // 寻找回文，最大只能在字符串中点
        while (i < s.length() && length < (s.length() - i)) {
            left = i;
            right = i + 1;
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            i = right;
            left--;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // 当前回文的长度
            int temp = right - left - 1;
            // 只有当回文触碰到左边界时才有用，否则无效，因为加字符只能在字符串的开头加，因此左边界一定要在预定范围内
            if (left == -1 && temp > length) {
                length = temp;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("a"));
    }
}
