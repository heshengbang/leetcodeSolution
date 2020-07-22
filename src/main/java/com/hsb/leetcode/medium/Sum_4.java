package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @since 2020/7/21 14:47
 */

public class Sum_4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> results = new ArrayList<>();
        for (int k = 0 ; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            for (int w = k + 1; w < nums.length - 2; w++) {
                if (w > k + 1 && nums[w] == nums[w-1]) {
                    continue;
                }
                int i = w + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j] + nums[w];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[k], nums[w], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i+1]) {
                            i++;
                        }
                        i++;
                        while (i < j && nums[j] == nums[i-1]) {
                            j--;
                        }
                        j--;
                    } else if (sum < target) {
                        while (i < j && nums[i] == nums[i+1]) {
                            i++;
                        }
                        i++;
                    } else {
                        while (i < j && nums[j] == nums[j-1]) {
                            j--;
                        }
                        j--;
                    }
                }
            }
        }
        return results;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end, key = nums[start];
        while (i < j) {
            while (nums[j] >= key && i < j) {
                j--;
            }
            while (nums[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = key;
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        Sum_4 item = new Sum_4();
        System.out.println(item.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }
}
