package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations_II {
    public static void main(String[] args) {
        Permutations_II item = new Permutations_II();
        int[] param = {1,1,2};
        System.out.println(item.permuteUnique(param));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 1) {
            return Collections.singletonList(Collections.singletonList(nums[0]));
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        do {
            result.add(toList(nums));
        } while (!hasNext(nums));
        return result;
    }

    private boolean hasNext(int[] nums) {
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return true;
        }
        int select = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                select = i;
                break;
            }
        }
        int tmp = nums[index];
        nums[index] = nums[select];
        nums[select] = tmp;
        reverse(nums, index + 1, nums.length - 1);
        return false;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int item: nums) {
            list.add(item);
        }
        return list;
    }
}
