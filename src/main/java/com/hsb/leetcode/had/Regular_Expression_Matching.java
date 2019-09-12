package com.hsb.leetcode.had;

/**
 * @author heshengbang
 * 2019/7/22.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

import java.util.ArrayList;
import java.util.List;

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
        // there may four type mode: 1. pure letters 2. dot 3. letter mix asterisk 4. dot mix asterisk
        List<String> patterns = parse(p);
        String rest = s;
        boolean hasPre = false;
        for (int i = 0; i <  patterns.size(); i++) {
            if (".".equals(patterns.get(i))) {
                if (i == patterns.size() - 1 && rest.length() == 1) {
                    return true;
                } else {
                    if (rest.length() == 0) {
                        return false;
                    } else {
                        if (!hasPre) {
                            rest = rest.substring(1);
                        }
                    }
                }
            } else if (".*".equals(patterns.get(i))) {
                hasPre = true;
            } else if (patterns.get(i).endsWith("*")) {
                rest = matchLetter(rest, patterns.get(i), hasPre);
                if (i == patterns.size() - 1) {
                    return rest.length() == 0;
                }
            } else if (!patterns.get(i).contains(".") && !patterns.get(i).contains("*")) {
                if (i == patterns.size() - 1) {
                    if (hasPre) {
                        return rest.endsWith(patterns.get(i));
                    } else {
                        return rest.equals(patterns.get(i));
                    }
                } else {
                    if (hasPre) {
                        if (rest.contains(patterns.get(i))) {
                            rest = rest.split(patterns.get(i))[1];
                        } else {
                            return false;
                        }
                    } else {
                        if (rest.startsWith(patterns.get(i))) {
                            rest = rest.substring(patterns.get(i).length());
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param pattern Mode like a* or b*
     */
    private static String matchLetter(String rest, String pattern, boolean hasPrefix) {
        String letter = pattern.replace("*", "");
        if (hasPrefix && !rest.startsWith(letter) && rest.contains(letter)) {
            rest = rest.substring(rest.indexOf(letter));
        }
        while (rest.startsWith(letter)) {
            rest = rest.substring(1);
        }
        return rest;
    }

    private static List<String> parse(String pattern) {
        List<String> patterns = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) {
            return patterns;
        }
        if (!pattern.contains("*")) {
            dealPattern(pattern, patterns, false);
            return patterns;
        }
        String[] subPattern = pattern.split("\\*");
        if (subPattern.length == 0) {
            patterns.add("*");
            return patterns;
        }
        for (int i = 0; i < subPattern.length; i++) {
            if (i == subPattern.length - 1) {
                if (pattern.endsWith("*")) {
                    dealPattern(subPattern[i], patterns, true);
                } else {
                    dealPattern(subPattern[i], patterns, false);
                }
            } else {
                dealPattern(subPattern[i], patterns, true);
            }
        }
        return patterns;
    }

    public static void dealPattern(String pattern, List<String> patterns, boolean haveAsterisk) {
        if (pattern.length() == 0) {
            return;
        }
        String part1 = pattern;
        String part2 = null;
        if (haveAsterisk) {
            part1 = pattern.substring(0, pattern.length() - 1);
            part2 = pattern.substring(pattern.length() - 1) + "*";
        }
        if (part1.length() > 0) {
            if (part1.contains(".")) {
                String[] subPart1s = part1.split("\\.");
                if (subPart1s.length > 0) {
                    for (int j = 0; j < subPart1s.length; j++) {
                        if (subPart1s[j].length() > 0) {
                            patterns.add(subPart1s[j]);
                        }
                        if (j != subPart1s.length - 1) {
                            patterns.add(".");
                        }
                    }
                } else {
                    patterns.add(".");
                }
            } else {
                patterns.add(part1);
            }
        }
        if (haveAsterisk && part2.length() > 0) {
            patterns.add(part2);
        }
    }
}
