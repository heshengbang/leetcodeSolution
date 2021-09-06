package com.hsb.leetcode.medium;

public class Sum_of_Two_Integers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a^b;
            //按位与再左移一位用来计算进位
            b = (a & b)<<1;
            a = temp;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(getSum(1,  2));
    }
}
