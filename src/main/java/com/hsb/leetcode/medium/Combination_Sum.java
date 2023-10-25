package com.hsb.leetcode.medium;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> ans;

            @Override
            public List<Integer> get(int index) {
                if (ans == null) {
                    init();
                }
                return ans.get(index);
            }

            private void init() {
                ans = new ArrayList<>();
                Arrays.sort(candidates);
                findCombination(0, target, new ArrayList<>());
            }

            private void findCombination(int index, int target, ArrayList<Integer> elements) {
                if (target == 0) {
                    ans.add(new ArrayList<>(elements));
                    return;
                }
                if (target < 0 || index == candidates.length) {
                    return;
                }
                for (int i = index; i < candidates.length; i++) {
                    if (target >= candidates[i]) {
                        elements.add(candidates[i]);
                        // 不限次数
                        findCombination(i, target - candidates[i], elements);
                        elements.remove(elements.size() - 1);
                    } else {
                        // 数组是经过排序的，后续都比当前元素大，不用再搜索
                        break;
                    }
                }
            }

            @Override
            public int size() {
                if (ans == null) {
                    init();
                }
                return ans.size();
            }
        };
    }

    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;

//        int[] candidates = {2,3,5};
//        int target = 8;

        int[] candidates = {2};
        int target = 1;


        Combination_Sum it = new Combination_Sum();
        List<List<Integer>> result = it.combinationSum(candidates, target);
        for (List<Integer> list: result) {
            for (Integer i: list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
