package com.hsb.leetcode.easy;

public class Valid_Palindrome_II {


    public static boolean validPalindrome(String s) {
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch - 'a'] ++;
        }
        int[][] map = new int[26][];
        // 初始化长度
        for (int i = 0; i < 26; i++) {
            map[i] = new int[count[i]];
        }
        count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'][count[s.charAt(i) - 'a']] = i;
        }
        boolean flag = true;
        for (int[] item: map) {
            int total = 0;
            for (int in: item) {
                total += in;
            }
            if (item.length % 2 == 0) {
                // 出现偶数次的，统计到的索引总和应该是s.length - 1的倍数
                if (total % (s.length() - 1) != 0) {
                    return false;
                }
            } else {
                // 出现奇数次，统计到的索引总和应该是s.length / 2 的倍数
                if (total % (s.length() / 2) != 0) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String item = "aba";
        System.out.println(validPalindrome(item));
    }

    public static boolean validPalindrome1(String s) {
        return valid(s, 0, s.length() - 1,  true);
    }

    private static boolean valid(String s, int left, int right, boolean flag) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
            return valid(s, left, right, flag);
        } else {
            if (flag) {
                return valid(s, left + 1, right, false) || valid(s, left, right - 1, false);
            } else {
                return false;
            }
        }
    }
}
