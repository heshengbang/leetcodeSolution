package com.hsb.leetcode.easy;

public class Number_of_Segments_in_a_String {
    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (!s.contains(" ")) {
            return 1;
        }
        int count = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (length != 0) {
                    count++;
                    length = 0;
                }
            } else {
                length++;
            }
        }
        if (length != 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(""));
    }
}
