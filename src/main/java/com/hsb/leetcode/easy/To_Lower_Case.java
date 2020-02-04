package com.hsb.leetcode.easy;

/**
 * 类描述:
 *
 * @version 1.0
 * @since 2020/2/4 22:09
 */

public class To_Lower_Case {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int diff = ('a' - 'A');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + diff);
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        To_Lower_Case item = new To_Lower_Case();
        System.out.println(item.toLowerCase("LOVELY"));
    }
}
