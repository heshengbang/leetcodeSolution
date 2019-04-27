package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/27 14:52
 *
 * @author heshengbang
 */

public class Excel_Sheet_Column_Title {
    public static String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    public static String convertToTitle1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char ch = (char) ('A' + --n % 26);
            sb.insert(0, ch);
            n = n / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle1(26));
    }

}
