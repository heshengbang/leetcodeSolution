package com.hsb.leetcode.easy;

import java.util.Arrays;

public class Duplicate_Zeros {
    public void duplicateZeros(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shiftingArray(arr, i + 1);
                i++;
            }
        }
    }

    private void shiftingArray(int[] arr, int left) {
        if (left >=  arr.length) {
            return;
        }
        if (arr.length - 1 - left >= 0) {
            System.arraycopy(arr, left, arr, left + 1, arr.length - 1 - left);
        }
        arr[left] = 0;
    }

    public static void main(String[] args) {
        Duplicate_Zeros item = new Duplicate_Zeros();
        int[] array = {0,0,0,0,0,0,0};
        item.duplicateZeros(array);
        System.out.println(Arrays.toString(array));
    }
}
