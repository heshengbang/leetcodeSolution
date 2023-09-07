package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/5 9:21
 *
 * @author heshengbang
 */

/**

 Climbing Stairs

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step

 */

public class ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * 状态参数使用楼梯数
     * 初始状态，当没有楼梯的时候，步数为0，当楼梯阶数是1的时候，到达方式也只有一种，当楼梯阶数为2的时候，到达方式有2种
     * 存储状态备忘录使用 dp[n]，dp[i] 代表到达第i个台阶有多少种方法
     * 状态转移方程 dp[i] = dp[i - 1] + dp[i - 2]
     *  dp[i - 1]走1步就可以到dp[i]
     *  dp[i - 2]走2步就可以到dp[i]
     *
     * @param n 台阶数
     * @return 多少种方式
     */
    public int climbStairsWithDp(int n) {
        // 初始状态
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        // 状态存储备忘录
        int[] ways = new int[n + 1];
        // 状态初始化
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            // 状态转移方程，空间优化策略，只用三个变量即可
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }

    public int climbStairsWithDp1(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] ways = new int[2];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 3; i < n + 1; i++) {
            int tmp = ways[0] + ways[1];
            ways[0] = ways[1];
            ways[1] = tmp;
        }
        return ways[1];
    }



    private static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return myClimbStairs(n, n, memo);
    }

    private static int myClimbStairs(int current, int n, int[] memo) {
        if (current <= 1) {
            return 1;
        }
        if (memo[current] > 0) {
            return memo[current];
        }
        memo[current] = myClimbStairs(current - 1, n, memo) + myClimbStairs(current - 2, n, memo);
        return memo[current];
    }

    public static void main(String[] args) {
        ClimbingStairs it = new ClimbingStairs();
        System.out.println(it.climbStairsWithDp1(3));
    }
}
