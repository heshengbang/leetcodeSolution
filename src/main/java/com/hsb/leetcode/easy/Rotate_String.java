package com.hsb.leetcode.easy;

/**
 * 类描述:
 * Copyright 多点生活（成都）科技有限公司
 *
 * @author hu.he@dmall.com 何虎
 * @version 1.0
 * @since 2021/8/12 9:48
 */

public class Rotate_String {
    public static boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i);
            if (goal.equals(sub2 + sub1)) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString1(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }
}
