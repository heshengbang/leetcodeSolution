package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/15 9:24
 *
 * @author heshengbang
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int i = 0;
        int buy, sell, profits = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sell = prices[i];
            profits = profits + sell - buy;
        }
        return profits;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0, buyPrice, sellPrice, length = prices.length;
        for (int i = 0; i < length - 1;) {
            while (i < length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buyPrice = prices[i];
            while (i < length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sellPrice = prices[i];
            profit = profit + (sellPrice - buyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,2,1,6,4,7,3,4};
        System.out.println(maxProfit(prices));
    }
}
