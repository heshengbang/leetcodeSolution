package com.hsb.leetcode.easy;

/**
 * 类描述:
 * Copyright trulyheshengbang@gmail.com
 *
 * @author heshengbang
 * @version 1.0
 * @since 2019/10/22 17:06
 */

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            array[sChars[i] - 'a'] ++;
            array[tChars[i] - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Anagram item = new Valid_Anagram();
        System.out.println(item.isAnagram("aaca", "ccac"));
    }
}
