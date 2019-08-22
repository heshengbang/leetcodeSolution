package com.hsb.leetcode.had;

/*
 * 类描述:
 * Copyright heshengbang
 * @since 2019/8/22 11:34
 * @version 1.0
 * @author trulyheshengbang@gmail.com heshengbang
 *************************************************
 */

/**
 * Shortest Common Supersequence
 *
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.
 *
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 *
 *
 * Note:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 *
 *
 * "bbbaaaba"  "bbababbb"   "bbabaaababb"
 */
public class Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0 || str1.contains(str2) || str2.contains(str1)) {
            return str1.length() < str2.length() ? str2 : str1;
        }
        // str1 + str2
        String result1 = "";
        for (int i = 0; i < str1.length(); i++) {
            String subString = str1.substring(i);
            if (str2.startsWith(subString)) {
                result1 = str1.substring(0, i) + str2;
            }
        }
        // str2 + str1
        String result2 = "";
        for (int i = 0; i < str2.length(); i++) {
            String subString = str2.substring(i);
            if (str1.startsWith(subString)) {
                result2 = str2.substring(0, i) + str1;
            }
        }
        if (result1.length() != 0 && result2.length() != 0) {
            return result1.length() < result2.length() ? result1 : result2;
        } else {
            return result1.length() < result2.length() ? result2 : result1;
        }
    }

    public static void main(String[] args) {
        Shortest_Common_Supersequence item = new Shortest_Common_Supersequence();
        System.out.println(item.shortestCommonSupersequence("bbbaaaba", "bbababbb"));
    }
}
