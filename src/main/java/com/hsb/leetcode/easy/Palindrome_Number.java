package com.hsb.leetcode.easy;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
