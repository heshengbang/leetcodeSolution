package com.hsb.leetcode.medium;

import java.math.BigDecimal;
import java.util.Arrays;

public class Product_of_Array_Except_Self {
    // bad solution
    public int[] productExceptSelf100(int[] nums) {
        int[] results = new int[nums.length];
        BigDecimal total = new BigDecimal(1);
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
                continue;
            }
            total = total.multiply(new BigDecimal(nums[i]));
        }
        if (countZero > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                results = new int[nums.length];
                results[i] = total.intValue();
                return results;
            }
            results[i] = total.divide(new BigDecimal(nums[i])).intValue();
        }
        return results;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            results[i + 1] = results[i] * nums[i];
        }
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = tmp * results[i];
            tmp = nums[i] * tmp;
        }
        System.gc();
        return results;
    }

    public static void main(String[] args) {
        Product_of_Array_Except_Self item = new Product_of_Array_Except_Self();
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(item.productExceptSelf100(nums)));

//        Product_of_Array_Except_Self item = new Product_of_Array_Except_Self();
//        int[] nums = {1,2,3,4};
//        System.out.println(Arrays.toString(item.productExceptSelf(nums)));
    }

}
