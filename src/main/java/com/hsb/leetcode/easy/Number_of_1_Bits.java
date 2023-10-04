package com.hsb.leetcode.easy;

/*
 * Copyright ©2011-2016 heshengbang
 */

/**
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 *
 */

public class Number_of_1_Bits {

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            // 无符号右移
            int tmp = n >>> 31;
            if (tmp == 1) {
                count++;
            }
            n = n << 1;
            System.out.println(Integer.toBinaryString(n));
        }
        return count;
    }

    public static void main(String[] args) {
        int n = -3;
        Number_of_1_Bits it = new Number_of_1_Bits();
        System.out.println(it.hammingWeight1(n));
    }



    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            if (((n >> i) & 1) == 1) {
                result++;
            }
        }
        return result;
    }
}
