package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/22 9:02
 *
 * @author heshengbang
 */

/**
 * Best Time to Buy and Sell Stock
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] > prices[i]) {
                    continue;
                }
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit <= 0 ? 0 : profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int goodBuyPrice = Integer.MAX_VALUE;
        int profit = 0, preProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (goodBuyPrice < prices[i]) {
                profit = Math.max(profit, prices[i] - goodBuyPrice);
            } else if (goodBuyPrice > prices[i]) {
                preProfit = Math.max(profit, preProfit);
                goodBuyPrice = prices[i];
                profit = 0;
            }
        }
        return Math.max(profit, preProfit);
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < n; i++) {
            if (buy < prices[i]) {
                int profit = prices[i] - buy;
                maxprofit = Math.max(maxprofit, profit);
            } else
                buy = prices[i];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock it = new Best_Time_to_Buy_and_Sell_Stock();
//        int[] array = {2,4,1};
//        System.out.println(it.maxProfit2(array));

//        int[] array = {7,1,5,3,6,4};
//        System.out.println(it.maxProfit2(array));

        int[] array = {3, 9, 2, 8, 1, 5};
        System.out.println(it.maxProfit3(array));
    }
}
