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
        int[] param1 = {1,2,3,4,5,6,7,8,9};
        System.out.println(coinChange(param1, 1997));
    }
}
