package com.hsb.leetcode.Medium;

/*
 * 类描述:
 * Copyright trulyheshengbang@gmail.com
 * @since 2019/7/9 9:51
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

/**
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * 遍历每个字符，以该字符为中心，向两边扩散，直到不满足回文条件为止
 *
 */

public class Longest_Palindromic_Substring {
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int index = 0, left, right, longest = 0, longestIndex = 0;
        while (index < chars.length) {
            left = index;
            right = left + 1;
            // 向右探测相同的字符，直到不相同的字符为止
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            // 下一轮循环则从不同的字符串处开始探测
            index = right;
            // 相同的字符，无论多少个都构成回文
            // 当向右探测到不同字符时，向左探测
            // 同时向左右开始探测回文
            left --;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left --;
                right++;
            }
            // 记录当前探测到的回文长度，此时的left是回文左边的一个索引，right是回文右边的索引，因此他们相减以后还要＋1
            int currentLen = right - left - 1;
            if (currentLen > longest) {
                longest = currentLen;
                longestIndex = left + 1;
            }
        }

        return s.substring(longestIndex, longestIndex + longest);
    }

    private static int max = 0, start = -1;
    public static String longestPalindrome2(String s) {
        if(s == null || s.length() < 2)
            return s;
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length;) {
            i = lps(ch, i);
        }
        return s.substring(start, start + max);
    }

    public static int lps(char[] ch, int l) {
        int r = l + 1;
        while(r < ch.length && ch[r] == ch[l]){
            r++;
        }
        int next = r;
        l--;
        while(l >= 0 && r < ch.length && ch[l] == ch[r]) {
            l--;
            r++;
        }
        int d = r - l - 1;
        if(d > max) {
            max = d;
            start = l + 1;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("cbbd"));
    }
}
