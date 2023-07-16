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

    public boolean isAnagram1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] table = new int[26];
        for (int i = 0; i < chars.length; i++) {
            table[chars[i] - 'a']++;
        }
        for (int i = 0; i < chart.length; i++) {
            if (table[chart[i] - 'a'] > 0) {
                table[chart[i] - 'a']--;
            } else {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Valid_Anagram item = new Valid_Anagram();
//        System.out.println(item.isAnagram1("aaca", "ccac"));
        System.out.println(item.isAnagram1("anagram", "nagaram"));

        System.out.println(item.isAnagram1("rat", "car"));

    }
}
