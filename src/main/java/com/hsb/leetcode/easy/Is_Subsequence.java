package com.hsb.leetcode.easy;

public class Is_Subsequence {
    public static boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1= t.toCharArray();
        if (s1.length == 0) {
            return true;
        } else if (t1.length == 0) {
            return false;
        }
        int sp1 = 0, tp1 = 0;
        while (sp1 < s.length() && tp1 < t1.length) {
            if (s1[sp1] == t1[tp1]) {
                sp1++;
            }
            tp1++;
        }
        return sp1 == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
