package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/27 16:42
 *
 * @author heshengbang
 */

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 */
public class Excel_Sheet_Column_Number {
    public static int titleToNumber(String s) {
        int results = 0;
        for (int i = 0; i < s.length(); i++) {
            results = results * 26 + (s.charAt(i) - 'A' + 1) ;
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
