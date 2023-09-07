package com.hsb.leetcode.medium;

/*
 * @author heshengbang
 * 2019/8/18.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
public class Coin_Change {

    /**
     * 硬币数量不限制，完全背包问题
     *
     * 初始状态，如果待组成的金额为0，则所使用的最少硬币数量为0
     *
     * 子问题：如果金额为i，那么尽量选择大的硬币面额比如x，那么剩余的金额i - x的问题解决就是一个子问题
     *
     * 状态参数选择金额的数额，那么状态存储备忘录就是dp[n]，其中dp[i]表示组成数额i所需要的最少硬币数量
     *
     * 状态转移方程就是dp[i] = Min(dp[i - x]), x ∈ coins
     *
     * @param coins 给定的硬币面额
     * @param amount 目标金额
     * @return 最少的硬币数量
     */
    public int coinChangeWith1DDP(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            // 如果没有找到合适的硬币就赋值-1
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            dp[i] = min;
        }
        return dp[amount];
    }

    /**
     * 上一个解法没考虑到coin的数量是无限制的
     * @return 最少的硬币数量
     */
    public int coinChangeWith1DDP1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                // 如果硬币面额大于当前金额，则什么都不做
                if (coin <= i) {
                    // 当前硬币取最大数量
                    int count = i / coin;
                    // 从最大数量到不取这个硬币，遍历一次
                    for (int j = count; j > 0; j--) {
                        // 剩下的金额
                        int rest = i - j * coin;
                        // 如果硬币数量+子问题的数量为最少，则替换之前的最小值
                        if (dp[rest] != -1) {
                            min = Math.min(min, dp[rest] + j);
                        }
                    }
                }
            }
            // 如果没有找到合适的硬币就赋值-1
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            dp[i] = min;
        }
        return dp[amount];
    }



    private static int[] resultCache = null;
    public static int coinChange(int[] coins, int amount) {
        if (resultCache == null) {
            resultCache = new int[2 * amount];
        } else {
            if (resultCache[amount] != 0) {
                return resultCache[amount];
            }
        }
        if (amount == 0) {
            return 0;
        }
        int minimum = 0;
        for (int coin : coins) {
            if (amount == coin) {
                resultCache[amount] = 1;
                return 1;
            } else if (amount > coin) {
                int result = coinChange(coins, amount - coin);
                if (result != -1) {
                    result++;
                    if (minimum <= 0) {
                        minimum = result;
                    } else {
                        minimum = result > 0 && result < minimum ? result : minimum;
                    }
                }
            }
        }
        int finalResult = minimum > 0 ? minimum : -1;
        resultCache[amount] = finalResult;
        return finalResult;
    }

    public static void main(String[] args) {
//        int[] param1 = {1,2,3,4,5,6,7,8,9};
        Coin_Change it = new Coin_Change();
        int[] param1 = {1,2,5};
        System.out.println(it.coinChangeWith1DDP1(param1, 11));
    }
}
