package com.hsb.leetcodeSolution.easy;

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
        System.out.println(climbStairs(3));
    }
}
