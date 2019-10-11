package com.hsb.leetcode.medium;

/**
 * 类描述:
 *
 * @author heshengbang
 * @version 1.0
 * @since 2019/10/9 15:16
 */

/**
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 */
public class Pow_x_n {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1/x, Integer.MAX_VALUE) * 1/x;
            } else {
                return myPow(1/x, -n);
            }
        }
        double value = myPow(x, n / 2);
        // 本题的精髓部分，不是逐个去累乘，而是将其进行分拆，相同的部分结果是一致的，减少计算量
        if (n % 2 == 0) {
            return value * value;
        } else {
            return value * value * x;
        }
    }

    public static void main(String[] args) {
        Pow_x_n item = new Pow_x_n();
        System.out.println(item.myPow(2.00000,
                -2147483648));
    }
}
