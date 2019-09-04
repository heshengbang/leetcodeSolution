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
 * "bbabacaa"  "cccababab"  "bbcccababcaab"
 */
public class Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0 || str1.contains(str2) || str2.contains(str1)) {
            return str1.length() < str2.length() ? str2 : str1;
        }
        int[][] results = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if (i == 0) {
                    results[0][j] = j;
                }
                if (j == 0) {
                    results[i][0] = i;
                }
            }
        }
        for (int str1Index = 1; str1Index < str1.length() + 1; str1Index++) {
            for (int str2Index = 1; str2Index < str2.length() + 1; str2Index++) {
                int select1 = results[str1Index - 1][str2Index] + 1;
                int select2 = results[str1Index][str2Index - 1] + 1;
                int select3;
                boolean isEqual = str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1);
                if (isEqual) {
                    select3 = results[str1Index - 1][str2Index - 1] + 1;
                } else {
                    select3 = results[str1Index - 1][str2Index - 1] + 2;
                }
                // 优先取select1，其次是select2，最后是select3
                if (select1 <= select2) {
                    if (select1 <= select3) {
                        results[str1Index][str2Index] = select1;
                    } else {
                        results[str1Index][str2Index] = select3;
                    }
                } else {
                    if (select2 <= select3) {
                        results[str1Index][str2Index] = select2;
                    } else {
                        results[str1Index][str2Index] = select3;
                    }
                }
            }
        }
        int str1Index = str1.length(), str2Index = str2.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (str1Index > 0 && str2Index > 0) {
            int select1 = results[str1Index - 1][str2Index] + 1;
            int select2 = results[str1Index][str2Index - 1] + 1;
            boolean isEqual = str1.charAt(str1Index - 1) == str2.charAt(str2Index - 1);
            if (results[str1Index][str2Index] == select1) {
                stringBuilder.append(str1.charAt(str1Index - 1));
                str1Index--;
            } else if (results[str1Index][str2Index] == select2) {
                stringBuilder.append(str2.charAt(str2Index - 1));
                str2Index--;
            } else {
                stringBuilder.append(str1.charAt(str1Index - 1));
                if (!isEqual) {
                    stringBuilder.append(str2.charAt(str2Index - 1));
                }
                str1Index--;
                str2Index--;
            }
        }
        String result = stringBuilder.reverse().toString();
        if (str1Index > 0) {
            result = str1.substring(0, str1Index) + result;
        }
        if (str2Index >0) {
            result = str2.substring(0, str2Index) + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Shortest_Common_Supersequence item = new Shortest_Common_Supersequence();
        String param1 = "bbbaaaba";
        String param2 = "bbababbb";
        String result = item.shortestCommonSupersequence(param1, param2);
        String expected = "bbabaaababb";
        System.out.println(result + "    " + expected + "   是否相等" + result.equals(expected));
    }
}
