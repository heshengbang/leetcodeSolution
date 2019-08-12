package com.hsb.leetcode.had;

/**
 * @author heshengbang
 * 2019/7/22.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 */
public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        } else if (s.length() == 0) {
            return p.length() == 0 || (p.length() == 2 && p.endsWith("*"));
        } else if (s.length() == 1) {
            return matchSingleWord(s, p);
        } else {
            String subString1 = s.substring(0, 1);
            String subString2 = s.substring(1);
            return matchSingleWord(subString1, p) && isMatch(subString2, p);
        }
    }

    private static boolean matchSingleWord(String s, String p) {
        return s.equals(p) || (p.length() == 3 && p.startsWith(s) && p.endsWith("*"));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }
}
