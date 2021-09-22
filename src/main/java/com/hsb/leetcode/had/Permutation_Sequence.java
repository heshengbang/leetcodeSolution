package com.hsb.leetcode.had;

public class Permutation_Sequence {

    public static void main(String[] args) {
        Permutation_Sequence item = new Permutation_Sequence();
        System.out.println(item.getPermutation(9, 56));
    }

    public String getPermutation(int n, int k) {
        int[] param = init(n);
        int count = 1;
        while (count < k) {
            nextPermutation(param);
            count++;
        }
        return toString(param);
    }

    private String toString(int[] param) {
        StringBuilder sb = new StringBuilder();
        for (int item: param) {
            sb.append(item);
        }
        return sb.toString();
    }

    private void nextPermutation(int[] param) {
        int length = param.length;
        int change;
        int i = length - 1;
        while (i > 0 && param[i - 1] > param[i]) {
            i--;
        }
        change = i - 1;
        if (change == -1) {
            return;
        }
        i = length - 1;
        while (i > change && param[change] > param[i]) {
            i--;
        }
        int changed = i;
        int tmp = param[changed];
        param[changed] = param[change];
        param[change] = tmp;
        reverse(param, change + 1, length - 1);
    }

    private void reverse(int[] param, int start, int end) {
        while (start < end) {
            int tmp = param[start];
            param[start] = param[end];
            param[end] = tmp;
            start++;
            end--;
        }
    }

    private int[] init(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
