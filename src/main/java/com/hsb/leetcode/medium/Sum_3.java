package com.hsb.leetcode.medium;

/*
 * @since 2019/10/28 15:45
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<List<Integer>> threeSum1(int[] nums) {
        nums = sortArray(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >0) {
                break;
            }
            results.addAll(twoSum(nums, i +1, nums.length - 1, nums[i], i));
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return results;
    }

    public int[] sortArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }
        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }
        int pointer = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[pointer] = minValue + i;
                pointer++;
                count[i]--;
            }
        }
        return nums;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target, int targetIndex) {
        List<List<Integer>> results = new ArrayList<>();
        while (start < end) {
            if (nums[start] + nums[end] + target == 0) {
                results.add(Arrays.asList(nums[targetIndex], nums[start], nums[end]));
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                start++;
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                end--;
            } else if (nums[start] + nums[end] + target < 0) {
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                start++;
            } else {
                // nums[start] + nums[end] + target > 0
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                end--;
            }
        }
        return results;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> tmp = find2Sum(nums, i + 1, target);
            if (tmp.size() != 0) {
                for (List<Integer> it: tmp) {
                    it.add(nums[i]);
                    results.add(it);
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return results;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length - 1 || start >= end) {
            return;
        }
        int left = start, right = end, flag = nums[end];
        while (left < right) {
            if (nums[left] <= nums[right]) {
                if (nums[left] == flag) {
                    right--;
                } else {
                    left++;
                }
            } else {
                if (nums[left] == flag) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    left++;
                } else {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    right--;
                }
            }
        }
        if (left - 1 >= start) {
            quickSort(nums, start, left - 1);
        }
        if (right + 1 <= end) {
            quickSort(nums, right + 1, end);
        }
    }

    private List<List<Integer>> find2Sum(int[] nums, int startIndex, int target) {
        if (startIndex >= nums.length - 1) {
            Collections.emptyList();
        }

        List<List<Integer>> list = new ArrayList<>();
        int i = startIndex, j = i + 1;
        while (i >= startIndex && j < nums.length) {
            if (nums[i] + nums[j] < target) {
                i++;
                j++;
            } else if (nums[i] + nums[j] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                list.add(tmp);
                j++;
                while (j < nums.length && nums[j - 1] == nums[j]) {
                    j++;
                }
            } else {
                i--;
            }
        }
        return list;
    }



    public static void main(String[] args) {
        Sum_3 item = new Sum_3();
        List<List<Integer>> results = item.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});

//        List<List<Integer>> results = item.threeSum2(new int[]{1, 0, 1});

//        List<List<Integer>> results = item.threeSum2(new int[]{0,0,0,0,0});

        for (List<Integer> list : results) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
