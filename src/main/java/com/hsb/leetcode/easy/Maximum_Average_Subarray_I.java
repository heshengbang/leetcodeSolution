package com.hsb.leetcode.easy;

public class Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        Double result = null;
        int total = 0, size = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (size < k) {
                total += nums[right++];
                size++;

                if (size == k) {
                    double tmp = Double.valueOf(total) / Double.valueOf(k);

                    if (result == null) {
                        result = tmp;
                    } else {
                        result = Math.max(tmp, result);
                    }
                    total -= nums[left++];
                    size--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;

//        int[] nums = {5};
//        int k = 1;

        int[] nums = {-1};
        int k = 1;

        Maximum_Average_Subarray_I it = new Maximum_Average_Subarray_I();
        System.out.println(it.findMaxAverage(nums, k));
    }
}
