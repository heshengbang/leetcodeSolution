package com.hsb.leetcode.had;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    /**
     * 备忘录采用三维数组dp[i][j][k]
     * 其中i表示第i天的最大利润
     * j表示是否持有股票，未持有为0，持有为1
     * k表示卖过几次股票，卖过0次为0，卖过1次为1，卖过2次为2
     * <p>
     * 对应的情况其实简单来说就是每一天就有是否持有股票，卖过几次股票来决定当天的最大利润
     * <p>
     * \            未持有股票                   持有股票
     * 卖过0次 |         ①最大利润肯定是0      | ②股票是否是当天购买
     * 卖过1次 |  ③当天卖出？/ 前一天卖出？     | ④当天买进？/ 前一天买进？
     * 卖过2次 |  ⑤当天卖出？/前一天卖出？      | ⑥不存在这种情况
     * <p>
     * 上面的六种情况依次编号，进一步解释
     * 第1种情况，没买过也没持有过，那么它的最大利润肯定是0，所以从第 0 ~ n的 dp[i][0][0] = 0，这是一种初始状态
     * 第6种情况，已经卖过两次股票，并且还持有股票，因为题目要求最多只能买卖两次，因此这种情况是不存在的，所以从第 0 ~ n的dp[i][1][2] = Integer.MIN_VALUE，终止条件
     * 第2种情况，卖过0次但是持有股票，那么只需要考虑这支股票是否是当天购买
     * 如果是当天购买，那么此时还没盈利，但是购买股票需要花钱，所以 dp[i][1][0] = prices[i]
     * 如果不是当天购买，那么就应该是前面购买的（但是不一定是前一天）
     * 当前情况下，前一天肯定持有股票，但是没卖过。（此时依然需要考虑是不是当天购买）这其实就是第2种情况，所以我们只需要考虑前一天的最优解dp[i - 1][1][0]
     * 因此 dp[i][1][0] = Math.max(prices[i], dp[i - 1][1][0]);
     * 第3种情况，卖过1次当天未持有股票，那么需要考虑这个股票是当天卖的还是之前卖的
     * 如果是当天卖的，那么当天的最大利润应该是 前一天的最大利润 加上 当天的股票价值
     * 当前情况下的前一天很显然是没卖过股票 但是持有股票的情况，因此取前一天的最大利润的时候应该取 dp[i - 1][1][0]
     * 如果不是当天卖的，那么就应该是之前卖的，这里面又分为是不是前一天卖的，其实就是第3种情况在前一天的最优解，但是前面已经计算过，即dp[i - 1][0][1]
     * 因此 dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1])
     * 第4种情况，卖过1次同时当天持有股票，买卖不能同一天，否则没有任何意义。所以肯定是先卖再买，所以考虑持股是什么时候买的
     * 如果是当天买的，则前一天应该是 【卖过一次，但是未持股】 这种情况下，应该减去当天买股票的花费 即 dp[i][1][1] = dp[i - 1][0][1] - prices[i]
     * 如果是之前买的，则前一天应该是 【卖过一次，同时也持股】，需要考虑所持股票是否当天购买， 而这 其实就是第4种情况，即 dp[i - 1][1][1]
     * 因此 dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1])
     * 第5种情况，卖出2次未持有股票，此时只需要考虑最近一次卖出股票的时间即可
     * 如果是当天卖出，则前一天的情况应该是 卖出过一次，同时持有股票，因此需要前一天的最优解加上卖股票的钱就是当天的最大利润，即 dp[i][0][2] = dp[i - 1][1][1] + prices[i]
     * 如果不是当天卖出，则是第5种情况的前一天的版本，只需要前一天的最优解即可  dp[i - 1][0][2]
     * 因此 dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2])
     * 上面六种情况的分析可以得出转移方程式
     * dp[i][j][k] =   0                                                             if  j = 0 k == 0
     * Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1])        if  j = 0 k = 1
     * Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2])        if  j = 0 k = 2
     * Math.max(prices[i], dp[i - 1][1][0])                          if  j == 1 k == 0
     * Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1])        if  j = 1 k = 1
     * Integer.MIN_VALUE                                             if  j == 1 k == 2
     * <p>
     * <p>
     * 此时可以给一个初始条件，如果是 i = 0的情况，此时不可能卖只能是持股或者不持股的情况
     * 因此，dp[0][0][0 ~ 2] = 0;  dp[0][1][0 ~ 2] = - prices[0]
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][2][3];
        // 初始化
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];
        for (int i = 0; i < length; i++) {
            dp[i][0][0] = 0;
            dp[i][1][2] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(-prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
        }
        return dp[length - 1][0][2];
    }

    public int maxProfit1(int[] prices) {
        // 第一次获利  和 第二次获利
        int profit1 = 0, profit2 = 0;
        // 第一次购买价，第二次购买价
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        // 遍历每一天
        for (int p : prices) {
            // 找到第一次购买价中的最低
            buy1 = Math.min(buy1, p);
            // 找到最高点出售，使得第一次获利最大
            profit1 = Math.max(profit1, p - buy1);

            buy2 = Math.min(buy2, p - profit1);
            profit2 = Math.max(profit2, p - buy2);
        }

        return profit2;
    }

    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};

        int[] prices = {6, 1, 3, 2, 4, 7};
        Best_Time_to_Buy_and_Sell_Stock_III it = new Best_Time_to_Buy_and_Sell_Stock_III();
        System.out.println(it.maxProfit1(prices));
    }
}
