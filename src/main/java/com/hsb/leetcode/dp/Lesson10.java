package com.hsb.leetcode.dp;

public class Lesson10 {
    private boolean canJump(int[] array) {
        boolean[] dp = new boolean[array.length];
        // 状态转移方程分析
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= array[i]; j++) {
                // 如果没超过数组的长度，就表明可以达到
                if (i + j < array.length) {
                    dp[i + j] = true;
                }
            }
        }
        boolean result = true;
        for (boolean it: dp) {
            result = result && it;
        }
        return result;
    }


    /**
     * 机器人在一个m * n的格子的左上角，要求它到右下角的不同路径的个数
     *  它每次只能往右边或者下边走一步
     * @param m 右边的格子数
     * @param n 下面的格子数
     * @return 路径个数
     */
    private int getPathCount(int m, int n) {
        // 横轴代表m方向的格子数
        // 纵轴代表n方向的格子数
        // 值代表原点到当前这个格子的路径总数
        int[][] dp = new int[m][n];
        // 默认到原点的路径数为0
        dp[0][0] = 0;
        // 最上面那行，由于到达格子的方式只能是左边到右边，所以到达路径只有1种
        for (int i = 1; i < n; i ++) {
            dp[0][i] = 1;
        }
        // 最左边的列，由于到达方式只能是上边往下，所以到达路径也只有一种
        for (int i = 1; i < m; i ++) {
            dp[i][0] = 1;
        }
        // 状态转移方程
        // 除第一列和第一行，其他格子到达的方式就有两种，要么是从上往下，要么是从左往右
        // 因此dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Lesson10 it = new Lesson10();
        System.out.println(it.getPathCount(3, 2));
        int[] jumps = {4, 2, 1, 0, 0, 6};
        System.out.println(it.canJump(jumps));
    }
}
