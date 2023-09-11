package com.hsb.leetcode.medium;

/**
 *
 * https://leetcode.com/problems/unique-paths-ii/?envType=study-plan-v2&envId=top-interview-150
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 *
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 */
public class Unique_Paths_II {
    /**
     * 初始状态，
     *      如果只有一行数据，那么到达最右侧的路径只有一条，如果中间有路障，那么路障后面的路径都应该为0
     *      如果只有一列数据，那么到达最下面的路径也只有一条，如果中间有路障，那么路障后面的路径都应该为0
     *  状态备忘录，dp[i][j]
     *      代表从obstacleGrid[0][0]到obstacleGrid[i - 1][j - 1]的不同走法
     *
     *  从题设分析，
     *      obstacleGrid[i - 1][j - 1] 如果为1，表示有障碍，无法到达那么dp[i][j] = 0
     *      obstacleGrid[i - 1][j - 1] 如果为0，表示可以同行，那么同行的方式要么从上往下，要么从左往右，所以到dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *  状态转移方程
     *      dp[i][j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1]
     *
     *  结果就是dp[obstacleGrid.length][obstacleGrid[0].length]
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 最左上角的到达方式取决于格子中的障碍物还是空
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // 只有一列数据的时候
        for (int i = 1; i < m; i++) {
            // 某个格子有0，那么它下面的格子都应该为0
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        // 只有一行数据的时候
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
    }
}
