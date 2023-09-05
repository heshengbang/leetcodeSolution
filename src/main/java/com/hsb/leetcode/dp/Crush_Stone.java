package com.hsb.leetcode.dp;


/**
 * 有一堆石头，每块石头的重量都是正整数，每次从中选出任意两块石头，然后将它们一起粉碎。
 * 假设石头的重量分别是x和y，且x<= y，那么粉碎的结果可能如下：
 *  如果x=y，那么两块石头都会被完全粉碎
 *  否则，重量为x的石头会被完全粉碎，重量为y的石头会被碎成重量为y - x的石头
 *
 * 最后，最多只会剩下一块石头。返回此时石头可能的最小重量，如果没有石头剩下，就返回0
 *
 *  示例：
 *      输入：[1 ,2 ,1 ,7 , 9, 4]
 *      输出：0
 *
 *
 * 解题思路：就是将石头分为重量近似的两堆，这样两堆互相碰撞以后的结果就会是最小的值。
 *
 */
public class Crush_Stone {
    private int crush_stone(int[] stones) {
        int total = 0;
        for (int stone: stones) {
            total += stone;
        }
        // 将分堆的目标值设为实际值的一半，然后尽可能的凑石头来达到这个目标，相当于往一个背包里面放石头
        int goal = total / 2;
        // 实际最多能放多少
        int actual = dp(stones, goal);
        // 多的值 - 少的值就等于最终结果
        return total - 2 * actual;
    }

    /**
     * 往目标容量为goal的背包中放石头
     * @param stones 石头堆
     * @param goal 目标容量
     * @return 最多能放到的容量
     */
    private int dp(int[] stones, int goal) {
        // 横轴为可用容量，纵轴为可用的石头，0代表没有，1代表第一个
        int[][] dp = new int[stones.length + 1][goal + 1];
        // 初始化，代表目标容量为0的时候，能放入的石头容量也为0
        for (int i = 0; i < stones.length + 1; i++) {
            dp[i][0] = 0;
        }
        // 初始化，代表可用石头为0是，能放入的
        for (int i = 0; i < goal + 1; i++) {
            dp[0][i] = 0;
        }

        for (int stone_index =1; stone_index < stones.length + 1; stone_index++) {
            for (int rest_space = 1; rest_space < goal + 1; rest_space++) {
                // 石头的索引和dp不一样
                if (stones[stone_index - 1] > rest_space) {
                    // 当前可用的这块石头大于可用容量的时候，无法将当前石头放入
                    // 沿用前一个最多能放的容量，即没有这个石头的时候
                    dp[stone_index][rest_space] = dp[stone_index - 1][rest_space];
                } else {
                    // 当前可用的这块石头小于等于可用容量的时候，就需要决策是否要将石头放入，需要比较放入和不放入的情况的收益值
                    // 放入的情况dp[stone_index - 1][rest_space - stones[stone_index - 1]] + stones[stone_index - 1]
                    // 不放入的情况和没有这块石头的情况一致，dp[stone_index - 1][rest_space]
                    dp[stone_index][rest_space] = Math.max(dp[stone_index - 1][rest_space - stones[stone_index - 1]] + stones[stone_index - 1], dp[stone_index - 1][rest_space]);
                }
            }
        }
        return dp[stones.length][goal];
    }

    public static void main(String[] args) {
        int[] stones = {1 ,2 ,1 ,7 , 9, 4};
        Crush_Stone crush_stone = new Crush_Stone();
        System.out.println(crush_stone.crush_stone(stones));
    }
}
