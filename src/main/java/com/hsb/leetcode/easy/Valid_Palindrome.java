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
 * https://leetcode.com/problems/valid-palindrome
 *
 */

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String palindrome = new StringBuilder(s).reverse().toString();
        return palindrome.equalsIgnoreCase(s);
    }

    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        String string = sb.toString();
        String reverse = sb.reverse().toString();
        return reverse.equals(string);
    }

    public static void main(String[] args) {
        Valid_Palindrome item = new Valid_Palindrome();
        System.out.println(item.isPalindrome1("Marge, let's \"went.\" I await news telegram."));
//        System.out.println(item.isPalindrome1("race a car"));
//        System.out.println(item.isPalindrome1("A man, a plan, a canal: Panama"));
    }
}
