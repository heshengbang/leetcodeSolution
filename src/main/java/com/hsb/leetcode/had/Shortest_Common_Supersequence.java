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
 * <p>
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.
 * <p>
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 * <p>
 * <p>
 * "bbbaaaba"  "bbababbb"   "bbabaaababb"
 */
public class Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0 || str1.contains(str2) || str2.contains(str1)) {
            return str1.length() < str2.length() ? str2 : str1;
        }
        String[][] results = new String[str1.length() + 1][str2.length() + 1];
        for (int str1Index = 1; str1Index < str1.length() + 1; str1Index++) {
            for (int str2Index = 1; str2Index < str2.length() + 1; str2Index++) {
                if (str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1)) {
                    if (results[str1Index - 1][str2Index - 1] == null) {
                        results[str1Index - 1][str2Index - 1] = "";
                    }
                    results[str1Index][str2Index] = results[str1Index - 1][str2Index - 1] + str1.charAt(str1Index - 1);
                } else {
                    if (results[str1Index - 1][str2Index] == null) {
                        results[str1Index - 1][str2Index] = "";
                    }
                    String temp1 = results[str1Index - 1][str2Index];
                    if (results[str1Index][str2Index - 1] == null) {
                        results[str1Index][str2Index - 1] = "";
                    }
                    String temp2 = results[str1Index][str2Index - 1];
                    results[str1Index][str2Index] = temp1.length() < temp2.length() ? temp1 : temp2;
                }
            }
        }
        return results[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        Shortest_Common_Supersequence item = new Shortest_Common_Supersequence();
        System.out.println(item.shortestCommonSupersequence("bbbaaaba", "bbababbb"));
    }
}
