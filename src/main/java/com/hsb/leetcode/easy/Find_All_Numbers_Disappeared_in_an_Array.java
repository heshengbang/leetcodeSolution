package com.hsb.leetcode.easy;

import java.util.ArrayList;
import java.util.List;


public class Find_All_Numbers_Disappeared_in_an_Array {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] map = new boolean[nums.length];
        for (int num: nums) {
            map[num - 1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (!map[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbersWithoutExtraSpace(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                list.add(i + 1);
            }
        }

        return list;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(findDisappearedNumbersWithoutExtraSpace(nums));
    }
}
