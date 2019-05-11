package com.hsb.leetcode.easy;

/*
 * Copyright ©2011-2016 heshengbang
 */

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 */
public class Reverse_Bits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int out = 0;

        // Iterate over the bits in n and assign them backward into out
        for (int i = 31; i >= 0; i--) {
            // get the value of the bit in spot (31 - i) from n: ((n >> (31 - i)) & 1)
            // Let's refer to this bit as X
            // set the value at bit i into out: out ^= X << i;
            int a = n >> (31 - i);
            int b = a & 1;
            int c = b << i;
            out = out ^ c ;

            System.out.println("a = " + Integer.toBinaryString(a) + " b = " + Integer.toBinaryString(b) + " c = " + Integer.toBinaryString(c) + " out = " + Integer.toBinaryString(out));
        }

        return out;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
