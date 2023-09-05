package com.hsb.leetcode.dp;

public class Knapsack_problem {

    private int fullKnapsack(int[] w, int[] v, int N, int W) {
        // 价值备忘录
        int[] dp = new int[W + 1];
        // 不能放重量的时候，价值为0
        dp[0] = 0;
        for (int i = 1; i < W + 1; i++) {
            // 当前这个容量的最大值源自上一个容量，除非这个容量下能放更多有价值的东西
            int maxValue = dp[i - 1];
            for (int j =0; j < N; j++) {
                // 如果当前这个物品超过了容量的总值，则什么都不做，沿用上一次的价值
                if (i >= w[j]) {
                    // 如果当前这个物品小于当前可用容量，则做决策，考虑是否要将物品放进来，分为放或者不放
                    // 放的情况下，就是当前物品的价值，加上没有这个物品的时候剩余空间所能放下的最大价值
                    int put = v[j] + dp[i - w[j]];
                    maxValue = Math.max(maxValue, put);
                }
            }
            dp[i] = maxValue;
        }
        return dp[W];
    }





    /**
     * 动态规划方式解决背包问题
     * 有一个背包，能放重量为W的物品，有一堆物品，它们的个数为N, 重量是分别在w的数组中，价值是分别在v的数组中，求能放入背包的物品的最大价值
     *  示例：W=5, N=3, w={3,2,1} v={5,2,3}
     * @param w 物品的重量数组
     * @param v 物品的价值数组
     * @param N 物品的个数
     * @param W 背包的重量
     * @return 背包能装的最大价值
     */
    private int simpleKnapsack(int[] w, int[] v, int N, int W) {
        // 代表背包里所放物品的价值，横轴代表背包的重量，纵轴代表可以选放的物品
        int[][] dp = new int[N + 1][W + 1];
        // 当背包能装的重量为0时，背包能装的价值也为0
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        // 第0个物品表示没有物品，没有物品的时候背包能装的价值为0
        for (int i = 0; i < W; i++) {
            dp[0][i] = 0;
        }

        // 从第一个物品开始遍历
        for (int t_index = 1; t_index < N + 1; t_index++) {
            // 从背包剩余空间为1开始遍历到最大值
            for (int rest_space = 1; rest_space < W + 1; rest_space++) {
                // 当前这个物品的重量大于背包剩余空间的量
                if (w[t_index] > rest_space) {
                    // 当前这个物品就无法放进来，只能沿用没有这个物品的时候的背包价值, 同时背包可用的空间不变
                    dp[t_index][rest_space] = dp[t_index - 1][rest_space];
                } else {
                    // 如果当前物品的重量小于或者等于背包剩余的空间
                    // 那么就权衡
                    // 放这个物品 dp[t_index - 1][rest_space - w[t_index]] + v[t_index]  放这个物品就会导致剩余空间发生变化rest_space - w[t_index]
                    //                  而这个剩余空间和没有这个物品时的背包价值已经在前面计算过了，因为它在二维数组的左上角，只需要将其加上当前物品的价值即可得到
                    // 不放这个物品 dp[t_index - 1][rest_space]
                    // 哪种方式拥有更大的价值
                    // 不用考虑边界值的问题，因为t_index是从1开始遍历，而0已经提前赋值。rest_space - w[t_index]不会小于0，也不会大于rest_space
                    dp[t_index][rest_space] = Math.max(dp[t_index - 1][rest_space - w[t_index]] + v[t_index], dp[t_index - 1][rest_space]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
//        int N = 3, W = 5;
//        int[] w = {0, 3, 2, 1};
//        int[] v = {0, 5, 2, 3};
//
//        Knapsack_problem it = new Knapsack_problem();
        //System.out.println(it.simpleKnapsack(w, v, N, W));

        int N = 3, W = 8;
        int[] w = {3, 2, 1};
        int[] v = {5, 2, 3};
        Knapsack_problem it = new Knapsack_problem();
        System.out.println(it.fullKnapsack(w, v, N, W));
    }
}





































