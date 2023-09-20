package com.hsb.leetcode.medium;

/**
 * 1和0相乘才能得到0
 * 2和0或者5相乘才能得到0
 * 3和0相乘才能得到0
 * 4和0或者5相乘才能得到0
 * 5和所有偶数相乘都能得到0
 * 6和5或者0相乘才能得到0
 * 7和0相乘才能得到0
 *
 * ⬇
 *
 * 除5以外的奇数和0相乘才能得到0
 * 偶数和0或者5相乘才能得到0
 * 0和任何书相乘都是0，并且0应该被统计而不是参与计算，所以不考虑0的情况
 *
 * 偶数和5相乘才能得0，除此以外没有其他情况
 *
 */
public class Factorial_Trailing_Zeroes {
    private int count = 0;

    /**
     * 大意是求n！的末尾有多少个0，可以想到要在末尾产生0，就必须有10才行
     * 排除0 * 任何数都为0的情况，因为0只会被统计，但是不会参与计算，否则会增加复杂度，
     * 只有 10=5*2 （其他5 * 偶数，都是5 * 2的变形），在阶乘中不缺2（因为每个奇数后面都是偶数，所以乘积除开0之后的数字一定是偶数）
     * 那么这个问题就变成了在这个阶乘中有多少个5的问题
     * 如 1*2*3*4*5 这里面就是1个5
     * 如 1*2*...10 可以变形为 1*2*3*...*9*2*5 这里面就就有2个5
     * 以此类推，最终算0的工作可以转换为算5的工作30的阶乘里面就是 6个5再加5*5里面多的一个5，所以是7个5
     *
     * @param n 阶乘的数字
     * @return
     */
    public int trailingZeroes(int n) {
            int result = 0;
            while (n > 0) {
                result += (n /= 5);
            }
            return result;
    }

    public static void main(String[] args) {
        Factorial_Trailing_Zeroes it = new Factorial_Trailing_Zeroes();
        System.out.println(it.trailingZeroes(10));
    }
}
