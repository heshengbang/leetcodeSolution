package com.hsb.leetcode.medium;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * https://leetcode.com/problems/maximal-square
 *
 */
public class Maximal_Square {
    /**
     *
     * 当格子中字符为0的时候，当前格子为右下角的最大正方形的大小为0
     * 状态参数为横竖两个索引
     * dp[i][j] 表示以matrix[i][j]为右下角的最大 的正方形 且其中所有格子的字符都是1的边长
     * dp[i][j]的值应该取决于
     *      dp[i - 1][j]，以matrix[i - 1][j]为右下角的所有格子字符都为1的正方形，假设正方形边长为0，1，2
     *      dp[i][j - 1]，以matrix[i][j - 1]为右下角的所有格子字符都为1的正方形，假设正方形边长为0，1，2
     *      dp[i - 1][j - 1]，以matrix[i - 1][j - 1]为右下角的所有格子字符都为1的正方形，假设正方形边长为0，1，2
     * 带入上述的假设情况可以得出结论，dp[i][j]只会取这三者中最小的值，再加上所在的格子1，构成以当前格子为右下角且所有格子字符都为1的最大正方形
     * 画一个3x3的格子，带入一下就会特别清楚
     *      dp[i - 1][j]、dp[i][j - 1]、dp[i - 1][j - 1]中有任何一个为0，那么dp[i][j]最大也只能为1，即0 + 1
     *      dp[i - 1][j]、dp[i][j - 1]、dp[i - 1][j - 1]中都不为0，但是有任何一个为1，那么dp[i][j]最大也只能为2，即1 + 1
     *      dp[i - 1][j]、dp[i][j - 1]、dp[i - 1][j - 1]中都不为0和1，那么dp[i][j]最大也只能为三者中最小的边长+1
     *
     * 因此状态转移方程为dp[i][j] = (matrix[i][j] == 1) ? Min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1 : 0;
     *
     * @param matrix 给定的0/1矩阵
     * @return 全为1的最大面积矩阵
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 || n == 1) {
            for (int i = 0; i < m ; i++) {
                // 找到任何一个1，就返回1
                if (matrix[i][0] == '1') {
                    return 1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        }
        // 定义备忘录
        int[][] dp = new int[m][n];
        int ans = 0;
        // 初始化
        for (int i = 0; i < m ; i++) {
            // 找到任何一个1，就返回1
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                ans = Math.max(ans, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                ans = Math.max(ans, 1);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j] ++;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'}};
        Maximal_Square it = new Maximal_Square();
        System.out.println(it.maximalSquare(matrix));
    }
}
