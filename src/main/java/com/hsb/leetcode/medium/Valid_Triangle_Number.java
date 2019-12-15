package com.hsb.leetcode.medium;

/*
 * 类描述:
 * @since 2019/12/13 22:14
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.Arrays;

/**
 *
 * Valid Triangle Number
 *
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 *
 *
 */
public class Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int left = j + 1, right = nums.length, sum2 = nums[i] + nums[j], mid;
                while (left < right) {
                    mid = left + (right - left)/2;
                    if (nums[mid] >= sum2) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                res += (left - j - 1);
            }
        }
        return res;
    }

    public int triangleNumber1(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] == 0) {
                        continue;
                    }
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[k] + nums[j] > nums[i]) {
                        System.out.println(nums[i] + "   " + nums[j] + "    " + nums[k]);
                        total++;
                    }
                }
            }
        }
        return total;
    }

    public int triangleNumber3(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < nums.length - 1) {
                int diff = nums[right] - nums[left];
                if (nums[i] <= diff) {
                    right--;
                } else {
                    res += (right - left);
                    left++;
                    right = nums.length - 1;
                }
                if (left == right) {
                    left++;
                    right = nums.length - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Valid_Triangle_Number item = new Valid_Triangle_Number();
        int[] arrays = {2,2,3,4};
        System.out.println(item.triangleNumber3(arrays));
    }
}
