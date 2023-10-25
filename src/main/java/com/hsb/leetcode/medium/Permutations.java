package com.hsb.leetcode.medium;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute1(int[] nums) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> ans;
            @Override
            public List<Integer> get(int index) {
                if (ans == null) {
                    init();
                }
                return ans.get(index);
            }
            @Override
            public int size() {
                if (ans == null) {
                    init();
                }
                return ans.size();
            }

            private void init() {
                if (ans != null) {
                    return;
                }
                ans = new ArrayList<>();
                int length = nums.length;
                Integer[] boxed = new Integer[length];
                for (int i = 0; i < length; i++) {
                    boxed[i] = nums[i];
                }
                find(boxed, 0);
            }

            private void find(Integer[] nums, int index) {
                if (index == nums.length - 1) {
                    List<Integer> list = new ArrayList<>();
                    for (Integer num: nums) {
                        list.add(num);
                    }
                    ans.add(list);
                    return;
                }
                for (int i = index; i < nums.length; i++) {
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
                    find(nums, index + 1);
                    tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
                }
            }
        };
    }





    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return Collections.singletonList(Collections.singletonList(nums[0]));
        }
        return fullPermute(nums, 0);
    }

    private static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>(nums.length);
            for (int item: nums) {
                tmp.add(item);
            }
            result.add(tmp);
        } else {
            for (int i = index; i < nums.length; i++) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                permute(nums, index + 1);
                tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
        return result;
    }

    private List<List<Integer>> fullPermute(int[] nums, int index) {
        if (index == nums.length - 1) {
            return Collections.singletonList(Collections.singletonList(nums[nums.length - 1]));
        }
        List<List<Integer>> tmp = fullPermute(nums, index + 1);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> item: tmp) {
            result.addAll(insertItem(nums[index], item));
        }
        return result;
    }

    private List<List<Integer>> insertItem(int num, List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(i, num);
            if (tmp.get(i) == num) {
                i++;
            }
            result.add(tmp);
        }
        return result;
    }


    public static void main(String[] args) {
        Permutations item = new Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> list = item.permute1(nums);
        for (List<Integer> it: list) {
            for (Integer i: it) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
}
