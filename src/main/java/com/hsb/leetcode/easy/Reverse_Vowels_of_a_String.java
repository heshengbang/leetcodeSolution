package com.hsb.leetcode.easy;

public class Reverse_Vowels_of_a_String {
    private static boolean find = false;
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && notVowels(chs[left])) {
                left++;
            }
            while (find && left < right && notVowels(chs[right])) {
                right--;
            }
            if (find) {
                char tmp = chs[left];
                chs[left] = chs[right];
                chs[right] = tmp;
                left++;
                right--;
                find = false;
            } else {
                break;
            }
        }
        return new String(chs);
    }

    private boolean notVowels(char ch) {
        if ("A".equalsIgnoreCase(String.valueOf(ch))) {
            find = true;
            return false;
        } else if ("E".equalsIgnoreCase(String.valueOf(ch))) {
            find = true;
            return false;
        } else if ("I".equalsIgnoreCase(String.valueOf(ch))) {
            find = true;
            return false;
        } else if ("O".equalsIgnoreCase(String.valueOf(ch))) {
            find = true;
            return false;
        } else if ("U".equalsIgnoreCase(String.valueOf(ch))) {
            find = true;
            return false;
        }
        return true;
    }
}
