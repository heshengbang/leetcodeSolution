package com.hsb.leetcode.medium;

public class Super_Pow {

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int item : b) {
            result = pow(result, 10) * pow(a, item) % 1337;
        }
        return result;
    }

    private int pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a % 1337;
        } else {
            if (a == 0) {
                return 0;
            } else if (a == 1) {
                return 1;
            }
            return pow(a % 1337, b / 2) * pow(a % 1337, b - b / 2) % 1337;
        }
    }

    private int quickPow(int a, int b, int mod) {
        int ans = 1;
        a = a % mod;
        // 10
        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % mod;
            }
            b = b / 2;
            a = (a * a) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        Super_Pow item = new Super_Pow();
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(item.superPow(a, b));
    }
}
