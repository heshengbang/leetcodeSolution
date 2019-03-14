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
Implement indexOf()

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 */

public class ImplementIndexOf {
    private static int indexOf(String haystack, String needle) {
        int count = 0, beginIndex = -1;
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return beginIndex;
        }
        boolean getIndex = true;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(count)) {
                if (getIndex) {
                    beginIndex = i;
                    getIndex = false;
                    if (beginIndex + needle.length() > haystack.length()) {
                        return -1;
                    }
                }
                if (count == needle.length() - 1) {
                    break;
                }
                count++;
                continue;
            }
            if (!getIndex){
                i = beginIndex;
            }
            beginIndex = -1;
            getIndex = true;
            count = 0;
        }
        return beginIndex;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("aaaaa", "ba"));
    }
}
