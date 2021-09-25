package com.hsb.leetcode.medium;

/*
 * Unique Binary Search Trees
 * 安明图数
 *
 * 设h(n)为catalan数的第n项，令h(0)=1,h(1)=1，catalan数满足递推式 [3]  ：
 * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)*h(0) (n≥2)
 * 例如：h(2)=h(0)*h(1)+h(1)*h(0)=1*1+1*1=2
 * h(3)=h(0)*h(2)+h(1)*h(1)+h(2)*h(0)=1*2+1*1+2*1=5
 *
 * 另类递推式：h(n-1)*(4*n-2)/(n+1)
 *
 */

public class Unique_Binary_Search_Trees {
    public static int numTrees(int n) {
        return tuMingAnNum(n).intValue();
    }

    public static Long tuMingAnNum(long n) {
        if (n == 0 || n == 1) {
            return 1L;
        }
        return tuMingAnNum(n - 1) * (4 * n - 2) / (n + 1);
    }

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }
}
