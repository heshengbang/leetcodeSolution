package com.hsb.leetcode.easy;

import java.util.Arrays;

public class Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        long biggest = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            long big = Long.MIN_VALUE;
            for (int num : nums) {
                if (num == biggest || num == second) {
                    continue;
                }
                if (num > big) {
                    big = num;
                }
            }
            if (i == 0) {
                biggest = big;
            } else if (i == 1) {
                second = big;
            } else {
                third = big;
            }
        }
        if (third == Long.MIN_VALUE) {
            return new Long(biggest).intValue();
        } else {
            return new Long(third).intValue();
        }
    }


    public static int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int index = 3;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length -1) {
                continue;
            } else if (nums[i] == nums[i + 1]){
                continue;
            } else {
                index--;
            }
            if (index == 1) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(thirdMax1(nums));
    }
}
