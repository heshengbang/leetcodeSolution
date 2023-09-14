package com.hsb.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 * https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        List<String> result = new ArrayList<>();
        int index = 0;
        StringBuilder tmp = new StringBuilder(String.valueOf(nums[index]));
        int count = 1;
        while (index + 1 < length) {
            if (nums[index] + 1 == nums[index + 1]) {
                index++;
                count++;
            } else {
                if (count > 1) {
                    tmp.append("->").append(nums[index]);
                }
                result.add(tmp.toString());
                index++;
                if (index < length) {
                    tmp = new StringBuilder(String.valueOf(nums[index]));
                    count = 1;
                }
            }
        }
        if (count == 1) {
            result.add(tmp.toString());
        } else {
            result.add(tmp.append("->").append(nums[length - 1]).toString());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        Summary_Ranges it = new Summary_Ranges();
        System.out.println(it.summaryRanges(nums));
    }
}
