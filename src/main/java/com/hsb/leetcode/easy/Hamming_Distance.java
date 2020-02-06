package com.hsb.leetcode.easy;

/**
 *
 * @version 1.0
 * @since 2020/2/6 22:08
 */

public class Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        int count = 0;
        while (value > 0) {
            if (value % 2 == 1) {
                count++;
            }
            value /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Hamming_Distance item = new Hamming_Distance();
        System.out.println(item.hammingDistance(1, 4));
    }
}
