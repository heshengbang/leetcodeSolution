package com.hsb.leetcode.medium;

public class Ugly_Number_II {
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            // 三个中选择较小的
            int factor2 = 2 * ugly[index2];
            int factor3 = 3 * ugly[index3];
            int factor5 = 5 * ugly[index5];
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                index2++;
            }
            if (factor3 == min) {
                index3++;
            }
            if (factor5 == min) {
                index5++;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {

    }
}
