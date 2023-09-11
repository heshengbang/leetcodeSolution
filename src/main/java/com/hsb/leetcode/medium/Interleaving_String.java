package com.hsb.leetcode.medium;

/**
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 *
 */
public class Interleaving_String {
    /**
     *
     * 这道题的本质上是每次从s1或者s2的头部选择一个字符，然后构成s3，每次选择都有两种可能，要么选s1,要么选s2，选中之后对应字符串的索引向后挪动一个
     *
     * 状态参数有两个，分别是s1的索引和s2的索引
     * 根据状态参数设定备忘录为dp[][]，其中dp[i][j]表示s1的前i个字符和s2的前j个字符是否交替构成了s3的前i+j个字符
     *      在设定状态备忘录以后发现这道题很像路径题，需要从左上角走到右下角，每一步都有两个选择，向右或者向下
     * 如果dp[i - 1][j]为true，表示s1的前i - 1个字符和s2的前j个字符可以构成s3的前i - 1 + j个字符，
     *      此时，s1的第i个字符和s3的第i + j个字符是否相等就决定了s1的前i个字符和s2的前j个字符是否可以交替构成s3的前i + j个字符
     *          如果相等，则dp[i][j]表示可行，如果不相等，则表示dp[i][j]不可行
     * 如果dp[i - 1][j]为false，表示s1的前i - 1个字符和s2的前j个字符不可以构成s3的前i - 1 + j个字符，更不要说在此基础上的dp[i][j]
     *
     * 同样的，dp[i][j - 1]也需要判断是否为true，逻辑和上面一致，因为s3的构成不一定只有一种方式，
     *      假定s1为aaaa, s2为aaaaaa，那么s3的构成方式应该有很多种
     *
     * 因此，状态转移方程dp[i][j] = dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j) || dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j);
     *
     * @param s1 给定字符串s1
     * @param s2 给定字符串s2
     * @param s3 给定字符串s3
     * @return s3是否由  s1和s2 的子字符串交替组成的
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        if (l1 == 0) {
            return s2.equals(s3);
        }
        if (l2 == 0) {
            return s1.equals(s3);
        }
        // 备忘录，dp[i][j]代表s3.subString(0, i + j)是否由s1.subString(0, i)和s2.subString(0, j)交替组成
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        // 初始化，如果s1 s2都为空，则s3应该也为空，所以00为true
        dp[0][0] = true;
        for (int i = 1; i < l1 + 1; i++) {
            // 如果s2为空字符，那么s3就是由s1构成，判断s3的前i个字符是否由s1的前i个字符构成
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i < l2 + 1; i++) {
            // 如果s1为空字符，那么s3就是由s2构成，判断s3的前i个字符是否由s1的前i个字符构成
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i < l1 + 1; i ++) {
            for (int j = 1; j < l2 + 1; j++) {
                // 如果dp[i][j]上面的一个格子是true，代表那条交替插入的路径是可行的，则判断一下s1最新的字符和s3最新的字符是否一样
                if (dp[i - 1][j]) {
                    // 代表s1新增的字符，这里之所以要-1是因为i的索引是从1开始的
                    char ch = s1.charAt(i - 1);
                    // 判断s3新增的字符是否和s1新增的字符一样，如果不一样，那么代表这条路不可行，如果一样，则为true
                    if (i - 1 + j < l3 && s3.charAt(i - 1 + j) == ch) {
                        dp[i][j] = true;
                    }
                }
                // 此处逻辑和dp[i - 1][j]一样
                if (dp[i][j - 1]) {
                    char ch = s2.charAt(j - 1);
                    // s3是由i + j的长度构成的，所以索引不用变化
                    if (i + j - 1 < l3 && s3.charAt(i + j - 1) == ch) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "a";

//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "aba";

        Interleaving_String it = new Interleaving_String();
        System.out.println(it.isInterleave(s1, s2, s3));
    }
}
