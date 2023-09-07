package com.hsb.leetcode.medium;

/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 */
public class Minimum_Path_Sum {
    /**
     * 从左上到右下，显然是要求路径，不过这个路径有一个值
     * 初始化，最顶上的一行数据，只有一种方法能到达，那就是从左边往右边，最左边的列也只有一种方法能到达，那就是从上往下。
     *
     * 状态参数两个：向右的索引，向下的索引
     *
     * 定义状态备忘录：dp[m][n]，其中dp[i][j]是指从00 到 i,j 这个位置的最小和
     *
     * 状态转移方程dp[i][j] = Min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j])
     *
     * @param grid 给定的矩形
     * @return 到达矩形右下角的最小和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // 初始化，最上面的一行是从左至右累加
        for (int i = 0; i < n; i++) {
            dp[0][i] = i - 1 >= 0 ? dp[0][i - 1] + grid[0][i] : grid[0][i];
        }
        // 初始化，最左一列是从上至下累加
        for (int i = 0; i < m; i++) {
            dp[i][0] = i - 1 >= 0 ? dp[i - 1][0] + grid[i][0] : grid[i][0];
        }
        // 从左至右开始遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Minimum_Path_Sum it = new Minimum_Path_Sum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(it.minPathSum(grid));
    }

}
