package com.hsb.leetcode.dp;

public class Lesson9 {

    private int getLongestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        // 横轴表示text2的子字符串，从0开始的
        // 纵轴表示text1的子字符串，从0开始的
        // 值表示text2的子字符串和text1的子字符串的最长公共子序列
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 初始化，只有text1，text2长度为0的时候，公共子序列为0
        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = 0;
        }
        // 同上，只有text2，text1长度为0的时候，公共子序列为0
        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = 0;
        }
        // dp[i][j]的值应该和text2.charAt(j)有关
        // 即如果text2.charAt(j) == text1.chatAt(i)
        //      那么此时dp[i][j] = dp[i - 1][j - 1] + 1;
        // 否则，text1.charAt(i)和text2.charAt(j)只能留一个，如果两个都不留，其实就是dp[i - 1][j - 1]，这个值已经求过了
        // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        // 分析dp[i][j]依赖的子问题，发现都在左上角，因此遍历循环的角度从左上到右下
        int ans = 0;
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    private int getLongestPalindromicSubSeq(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        // 纵轴是子字符串开始的地方，横轴是子字符串结束的地方，值是子字符串中最长回文子序列的长度
        int[][] dp = new int[length][length];
        // 对于单个字符来说，它就是子字符串中最长回文子序列本身，也就是长度为11
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        // 当前新加入子字符串的字符x，是否与子字符串开始的位置的字符一致？
        // 如果一致则考虑将其纳入到最长回文子序列中，此时dp[i][j] = dp[i + 1][j - 1] + 2，相应的，它的子问题就是求dp[i + 1][j - 1]，而这个值应该已经求过了
        // 如果不一致，则需要考虑子字符串的最左边的字符和最右边的字符，哪一个纳入到子序列中会产生更长的回文子序列
        //      如果只将左边纳入，则应该是dp[i][j - 1]
        //      如果只将右边纳入，则应该是dp[i + 1][j]
        //      最差的情况是，左边和右边的纳入都不能增加回文子序列的长度，所以保底应该是dp[i + 1][j - 1]但是这种情况其实包含在dp[i][j - 1]中，所以不用考虑
        // 状态转移方程就是  dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 : Math.max(dp[i][j - 1], dp[i + 1][j]);

        // 答案最小都是1
        int ans = 1;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                ans = Math.max(dp[i][j], ans);
            }
        }


        // 开始位置从0开始遍历
//        for (int i = 0; i < length; i++) {
//            // 由于前面已经处理过单个字符的字符串的问题，所以这里不考虑i == j的情况，直接从j = i + 1开始
//            for (int j = i + 1; j < length; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 : Math.max(dp[i][j - 1], dp[i + 1][j]);
//                // 保留最大值为答案，避免后面再来循环遍历求值
//                ans = Math.max(ans, dp[i][j]);
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        Lesson9 it = new Lesson9();
//        System.out.println(it.getLongestPalindromicSubSeq("asssamms"));


        String text1 = "abcde";
        String text2 = "ade";
        System.out.println(it.getLongestCommonSubsequence(text1, text2));
    }
}
