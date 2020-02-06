package com.hsb.leetcode.medium;

import java.util.Arrays;

/**
 * @version 1.0
 * @since 2020/2/6 21:20
 */

public class Counting_Bits {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        } else if (num == 1) {
            return new int[]{0, 1};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int addIndex = 0;
        for (int i = 2; i < num + 1; i++) {
            if (addIndex == 0) {
                addIndex = i - 1;
                result[i] = 1;
            } else {
                result[i] = result[i - addIndex] + 1;
                addIndex--;
            }
        }
        return result;
    }

    // 0 1 10 11 100 101 110 111 1000 1001  1010  1011  1100  1101  1110  1111  10000
    public static void main(String[] args) {
        Counting_Bits item = new Counting_Bits();
        System.out.println(Arrays.toString(item.countBits(121)));
    }
}
