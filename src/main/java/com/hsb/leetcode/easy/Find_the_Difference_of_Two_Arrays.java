package com.hsb.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_the_Difference_of_Two_Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int num: nums1) {
            s1.add(num);
        }

        for (int num: nums2) {
            s2.add(num);
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int num: s1) {
            if (!s2.contains(num)) {
                l1.add(num);
            }
        }
        for (int num: s2) {
            if (!s1.contains(num)) {
                l2.add(num);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(l1);
        result.add(l2);
        return result;
    }
}
