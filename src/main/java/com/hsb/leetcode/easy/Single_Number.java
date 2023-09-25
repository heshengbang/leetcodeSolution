package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/19 9:45
 *
 * @author heshengbang
 */

/**
 *
 * Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class Single_Number {


    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }




    public static int singleNumber(int[] nums) {
        int value = 0;
        for (int num: nums) {
            value = value ^ num;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] params = {4,1,2,1,2};
        System.out.println(singleNumber(params));
    }
}
