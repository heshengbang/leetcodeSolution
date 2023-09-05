package com.hsb.leetcode.dp;

public class Palindromic_Substrings {
    private int palindromic_substrings(String str) {
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        int ans = 0;
        boolean[][] dp = new boolean[length][length];
        // 起止位置都相同的时候，是一个字符，此时就是回文子串
        for (int i =0; i < length; i++) {
            dp[i][i] = true;
            ans++;
        }
        // 字符串的起始位置从0开始
        for (int i = 0; i < str.length(); i++) {
            char startChar = str.charAt(i);
            // 字符串的结束位置，上面已经处理了单个字符的情况，所以这里结束的字符串必须大于起始位置
            for (int j = i + 1; j < str.length(); j++) {
                // j - i < 3，表示j - i 之间的差距小于3，由于差距不可能为0（因为j = i + 1）所以，差距只可能为1或者2
                // 假设差距为2，那么i到j之间就是三个字符，在i和j处字符相同的情况下，中间无论是什么字符都是回文
                // 假设差距为1，那么i和j处字符相同，自然就是回文
                dp[i][j] = (startChar == str.charAt(j)) && (j - i < 3 ||  dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Palindromic_Substrings it = new Palindromic_Substrings();
        System.out.println(it.palindromic_substrings("dp"));
    }
}
