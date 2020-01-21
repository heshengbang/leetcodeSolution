package com.hsb.leetcode.medium;

/*
 * @since 2020/1/20 23:03
 * @version 1.0
 */

import java.util.Arrays;

public class Sum_3_closest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] + nums[1];
        } else if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                } else if (end == i) {
                    end--;
                    continue;
                }
                int total = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - total) < closest) {
                    closest = Math.abs(target - total);
                    result = total;
                }
                if (total > target) {
                    end--;
                } else if (total < target){
                    start++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sum_3_closest item = new Sum_3_closest();
        int[] nums = {0,2,1,-3};
        int target = 0;
        System.out.println(item.threeSumClosest(nums, target));
    }
}
