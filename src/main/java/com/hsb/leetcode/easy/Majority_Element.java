package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/27 16:08
 *
 * @author heshengbang
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */
public class Majority_Element {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int item: nums) {
            if (countMap.containsKey(item)) {
                int count = countMap.get(item);
                countMap.put(item, count + 1);
            } else {
                countMap.put(item, 1);
            }
        }
        int result = 0;
        int biggest = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> item: countMap.entrySet()) {
            if (item.getValue() > biggest) {
                biggest = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }

    public static int majorityElement2(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums));
    }
}
