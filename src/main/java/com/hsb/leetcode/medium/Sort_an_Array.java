package com.hsb.leetcode.medium;

import java.util.Arrays;

/**
 * 类描述:
 * @since 2020/7/17 10:56
 */

public class Sort_an_Array {
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    public int[] quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }
        int low = start , height = end;
        int key = nums[start];
        while (start < end) {
            while (nums[end] >= key && start < end) {
                end--;
            }
            while (nums[start] <= key && start < end) {
                start++;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[low] = nums[start];
        nums[start] = key;
        quickSort(nums, low,  start- 1);
        quickSort(nums, start + 1, height);
        return nums;
    }


    public int[] sortArray2(int[] nums) {
        quickSort2(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort2(int[] nums, int start, int end) {
        if (start == end) {
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
                    nums[right] = flag;
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
        if (start < left - 1) {
            quickSort2(nums, start, left - 1);
        }
        if (right + 1 < end) {
            quickSort2(nums, right + 1, end);
        }
    }

    public static void main(String[] args) {
        Sort_an_Array executor = new Sort_an_Array();
        System.out.println(Arrays.toString(executor.sortArray2(new int[]{-100, 5,1,1,2,0,0})));

//        System.out.println(Arrays.toString(executor.sortArray2(new int[]{5,2,3,1})));


    }

    public int[] sortArray1(int[] nums) {
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
}
