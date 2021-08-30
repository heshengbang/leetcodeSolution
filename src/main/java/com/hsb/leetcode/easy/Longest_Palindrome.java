package com.hsb.leetcode.easy;

public class Longest_Palindrome {
    public static int longestPalindrome(String s) {
        int[] low = new int[26];
        int[] up = new int[26];
        for (char ch: s.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                low[ch - 'a'] ++;
            }
            if ('A' <= ch && ch <= 'Z') {
                up[ch - 'A'] ++;
            }
        }
        int result = 0;
        boolean hasSingle = false;
        for (int i = 0; i < 26; i++) {
            if (low[i] % 2 == 0) {
                result += low[i];
            } else {
                hasSingle = true;
                result += (low[i] - 1);
            }
            if (up[i] % 2 == 0) {
                result += up[i];
            } else {
                hasSingle = true;
                result += (up[i] - 1);
            }
        }
        if (hasSingle) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
