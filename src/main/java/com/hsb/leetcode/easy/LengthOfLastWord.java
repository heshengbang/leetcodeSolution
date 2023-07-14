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
Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

https://leetcode.com/problems/length-of-last-word


 */

public class LengthOfLastWord {
    private static int lengthOfLastWord(String s) {
        int count = 0, lastCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (count != 0) {
                    lastCount = count;
                }
                count = 0;
            } else {
                lastCount = 0;
                count++;
            }
        }
        if (count == 0) {
            count = lastCount;
        }
        return count;
    }

    public int lengthOfLastWord1(String s) {
        int length = 0;
        boolean findLast = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (findLast) {
                    break;
                } else {
                    continue;
                }
            } else {
                findLast = true;
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("Hello World"));

        LengthOfLastWord item = new LengthOfLastWord();
//        System.out.println(item.lengthOfLastWord1("Hello World"));

        System.out.println(item.lengthOfLastWord1("   fly me   to   the moon  "));

        System.out.println(item.lengthOfLastWord1("luffy is still joyboy"));
    }
}
