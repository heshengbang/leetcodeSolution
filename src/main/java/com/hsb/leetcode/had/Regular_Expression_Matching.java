package com.hsb.leetcode.had;

/**
 * @author heshengbang
 * 2019/7/22.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();
        return match(s, p, map);
    }

    public boolean match(String s, String p, Map<String, Boolean> results) {
        String key = s + "-" + p;
        if (results.containsKey(key)) {
            return results.get(key);
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (p.length() == 0) {
            return false;
        } else if (s.length() == 0) {
            return parse(p);
        }
        String currentLetter = s.substring(s.length() - 1);
        String restLetter = s.substring(0, s.length() - 1);
        String currentPattern = p.substring(p.length() - 1);
        String restPattern = p.substring(0, p.length() - 1);
        if ("*".equals(currentPattern)) {
            currentPattern = p.substring(p.length() - 2);
            restPattern = p.substring(0, p.length() - 2);
        }
        if (".".equals(currentPattern)) {
            results.put(key, match(restLetter, restPattern, results));
        } else if (".*".equals(currentPattern)) {
            results.put(key, match(restLetter, p, results) || match(restLetter, restPattern, results) || match(s, restPattern, results));
        } else if (currentPattern.endsWith("*")) {
            if (currentPattern.contains(currentLetter)) {
                results.put(key, match(restLetter, restPattern, results) || match(restLetter, p, results) || match(s, restPattern, results));
            } else {
                results.put(key, match(s, restPattern, results));
            }
        } else {
            results.put(key, currentPattern.equals(currentLetter) && (match(restLetter, restPattern, results)));
        }
        return results.get(key);
    }

    private boolean parse(String pattern) {
        if (pattern.length() % 2 == 1) {
            return false;
        }
        for (int i = 1; i < pattern.length(); ) {
            if (!"*".equals(pattern.substring(i, i + 1))) {
                return false;
            }
            i = i + 2;
        }
        return true;
    }

    public static void main(String[] args) {
//        Regular_Expression_Matching item = new Regular_Expression_Matching();
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("mississippi", "mis*is*p*."));
//        System.out.println(isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"));
//        System.out.println(isMatch("a", "ab*a"));
        // expected true
//        System.out.println(isMatch("aaa", "a*a"));
        // expected true
        System.out.println(new Regular_Expression_Matching().isMatch("aaa", "ab*ac*a"));
        // expected false

//        System.out.println(isMatch("a", ".*..a*"));
        // expected true
//        System.out.println(isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c"));

    }
}
