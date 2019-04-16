package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/16 15:38
 *
 * @author heshengbang
 */

/**
 *
 * Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 */

public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String palindrome = new StringBuilder(s).reverse().toString();
        return palindrome.toUpperCase().equals(s.toUpperCase());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Marge, let's \"went.\" I await news telegram."));
    }
}
