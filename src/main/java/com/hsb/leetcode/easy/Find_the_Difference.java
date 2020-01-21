package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/1/21 16:27
 */

public class Find_the_Difference {
    public char findTheDifference(String s, String t) {
        int[] original = new int[26];
        for (int i = 0; i < s.length(); i++) {
            original[s.charAt(i) - 'a']++;
        }
        int[] shuffling = new int[26];
        for (int i = 0; i < t.length(); i++) {
            shuffling[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26;i++) {
            if (original[i] != shuffling[i]) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }

    public char findTheDifference1(String s, String t) {
        int res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        return (char) res;
    }

    public static void main(String[] args) {
        Find_the_Difference item = new Find_the_Difference();
        System.out.println(item.findTheDifference1("abcd", "abcde"));
    }
}
