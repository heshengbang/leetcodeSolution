package com.hsb.leetcode.dp;

public class MaxSumOfSubArray {
    private int maxSumOfSubArrayWith1D(int[] array) {
        // 以i为结束位置的最大子数组之和
        int[] dp = new int[array.length + 1];
        // 表示数组为空时，子数组拥有的最大和
        dp[0] = 0;
        int ans = Integer.MIN_VALUE;
        // 当求 以i为结束位置的最大子数组之和 的时候， 即求dp[i]的时候，
        // 当前一个位置的值为正数的时候，连上i这个位置，可以使以i为结束位置的子数组的最大和变大，即dp[i - 1] + array[i]
        // 当前一个位置的值为负数的时候，脸上i这个位置，使得以i为结束位置的子数组的最大和表笑，所以只应该取array[i]
        // 所以状态转移方程就是 dp[i] = dp[i - 1] > 0 ? dp[i - 1] + array[i] : array[i];
        // 从状态转移方程来看，此处的优化空间就是dp[i]其实只和dp[i - 1]有关，dp数组的其他元素无关，所以空间上可以更优化，用一个大小为2的一维数组即可
        // 比如x表示前一个状态，y表示当前状态，那么y = x > 0 ? x + array[i] : array[i]; x = y; 这样就可以完成一轮循环
        for (int i = 1; i < array.length + 1; i++) {
            // 此处array的索引和dp不一致，array应该从0开始
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + array[i - 1] : array[i - 1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private int maxSumOfSubArrayWith2D(int[] array) {
        // 纵轴表示子数组开始的位置，横轴表示子数组结束的位置，值代表开始位置到结束位置的子数组的和
        int[][] dp = new int[array.length][array.length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            dp[i][i] = array[i];
            ans = Math.max(dp[i][i], ans);
        }
        // 从数组开始的位置作为子数组的开始的位置开始遍历

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                dp[i][j] = dp[i][j - 1] + array[j];
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 3, -5, 1, 2};
        MaxSumOfSubArray it = new MaxSumOfSubArray();
        System.out.println(it.maxSumOfSubArrayWith1D(array));
    }
}
