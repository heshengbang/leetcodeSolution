package com.hsb.leetcode.medium;

/*
 * @since 2019/10/28 15:45
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Sum_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] <= 0) {
                left = i + 1;
                right = nums.length - 1;
            } else {
                break;
            }
            results.addAll(find(nums, i, left, right));
        }
        return results;
    }

    private List<List<Integer>> find(int[] nums, int current, int left, int right) {
        List<List<Integer>> results = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] + nums[current] < 0) {
                left++;
            } else if (nums[left] + nums[right] + nums[current] == 0) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[current]);
                result.add(nums[left]);
                result.add(nums[right]);
                results.add(result);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else {
                right--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Sum_3 item = new Sum_3();
        List<List<Integer>> results = item.threeSum(new int[]{0, 0, 0});
        for (List<Integer> list : results) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
