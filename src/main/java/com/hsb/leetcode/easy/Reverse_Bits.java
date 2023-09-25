package com.hsb.leetcode.easy;


/*
 * Copyright ©2011-2016 heshengbang
 *
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

    /**
     *
     * 将数字n的每一位，从左至右，无符号右移31位，舍弃它右边的其他位数的值，再将其向左移动到reverse应该在的位置，比如32位对应1位，31位对应2位
     * 然后和0位基底的上一轮的值做或运算，得到结果
     * 将n左移一位，继续运算其他位数
     *
     * 举例：
     *
     * 假设 x = 01110101010101010101010101010101
     * 运算第一轮 x >>> 31，无符号右移，左边填充0，得tmp = 0
     * tmp 向左移动 0位，tmp仍为 0
     * tmp 和 ans 做或运算 0 | 0，ans 为 0
     * x 左移动1位，右边填充 0，此时 x = 11101010101010101010101010101010
     *
     * 运算第二轮 x >>> 31，无符号右移，左边填充0，得tmp = 1
     * tmp 向左移动 1位，tmp为 10
     * tmp 和 ans做或运算 10 | 0，ans 为 10
     * x 左移动1位，右边填充 0，此时 x = 11010101010101010101010101010100
     *
     * 运算第三轮 x >>> 31，无符号右移，左边填充0，得tmp = 1
     * tmp 向左移动 2位，tmp为 100
     * tmp 和 ans做或运算 100 | 10，ans 为 110
     * x 左移动1位，右边填充 0，此时 x = 10101010101010101010101010101000
     *
     * 运算第四轮 x >>> 31，无符号右移，左边填充0，得tmp = 1
     * tmp 向左移动 3位，tmp为 1000
     * tmp 和 ans做或运算 1000 | 110，ans 为 1110
     * x 左移动1位，右边填充 0，此时 x = 01010101010101010101010101010000
     *
     */
    public static int reverseBits2(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 无符号左移31位，此时tmp就是0/1的情况
            int tmp = n >>> 31;
            // 右移i位，此时tmp除了i位左右皆为0
            tmp = tmp << i;
            // 和0为基地的数字做或运算，对应位置的值就会变更
            ans = ans | tmp;
            // 计算过的位置顶替掉，进入下一轮循环
            n = n << 1;
        }
        return ans;
    }


    public static int reverseBits1(int n) {
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
        if (sb.length() < 32) {
            for (int i = sb.length(); i < 32; i++) {
                sb.insert(0, '0');
            }
        }
        int times = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (sb.charAt(i) == '0') {
                times = 2 * times;
                continue;
            }
            ans += times;
            times = 2 * times;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits2(964176192));
    }



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
}
