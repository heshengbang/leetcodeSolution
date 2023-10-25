package com.hsb.leetcode.medium;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.*;

public class Combinations {
    List<List<Integer>> mem = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombine(1, n, k, new ArrayList<>());
        return mem;
    }

    private void findCombine(int start, int end, int k, ArrayList<Integer> list) {
        if (start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            list.add(i);

            if (list.size() == k) {
                mem.add(new ArrayList<>(list));
            } else {
                if (list.size() + (end - i) >= k) {
                    findCombine(i + 1, end, k, list);
                }
            }
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
//        int n = 4, k = 2;
        int n = 1, k = 1;

        Combinations combinations = new Combinations();
        List<List<Integer>> list = combinations.combine(n, k);
        for (List<Integer> it: list) {
            for (Integer i: it) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
