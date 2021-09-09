package com.hsb.leetcode.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        int[] map = new int[nums.length];

        for (int num: nums) {
            map[num - 1]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < map.length; i++) {
            if (map[i] > 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static List<Integer> findDuplicatesWithOutExtraSpace(int[] nums) {

        for (int i = 0; i < nums.length;i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i] && nums[nums[i] - 1] == nums[i]) {
                list.add(nums[i]);
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
        int[] nums = {1,1,2};
        System.out.println(findDuplicatesWithOutExtraSpace(nums));
    }
}
