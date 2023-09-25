package com.hsb.leetcode.had;

public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        // dp[i][j][k] 表示 prices长度只有i的时候，持有或者没有持股的情况下，已经售卖k次股票的最大利润
        int[][][] dp = new int[length][2][k + 1];
        // 初始条件
        for (int i = 0; i < length; i++) {
            // 未持股，卖股次数为0的情况下，最大收益为0
            dp[i][0][0] = 0;
            // 持股同时已卖股k次的情况不存在，设置最小值
            dp[i][1][k] = Integer.MIN_VALUE;
        }
        // 当prices长度只有1的情况下
        // 未持股，也不可能卖股，所以最大收益为0
        // 持股，这个股也只有第0天当天买入，所以当天收益为-prices[0]
        for (int i = 0; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        // i = 0 的时候是上面的初始条件
        for (int i = 1; i < length; i++) {
            for (int x = 0; x <= k; x++) {
                if (x == 0) {
                    // 未持股也没卖出过，最大利润为0
                    dp[i][0][x] = 0;
                } else {
                    dp[i][0][x] = Math.max(dp[i - 1][1][x - 1] + prices[i], dp[i - 1][0][x]);
                }

                if (x < k) {
                    dp[i][1][x] = Math.max(dp[i - 1][0][x] -prices[i], dp[i - 1][1][x]);
                }
                if (x == k) {
                    dp[i][1][x] = Integer.MIN_VALUE;
                }
            }
        }
        return dp[length - 1][0][k];
    }
}
