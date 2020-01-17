package com.hsb.leetcode.easy;

/*
 * @since 2020/1/16 21:19
 * @version 1.0
 *************************************************
 */

import java.util.HashMap;
import java.util.Map;

public class House_Robber {
    private Map<String, Integer> redis = new HashMap<>();
    private int recursion1(int[] nums, int index, boolean next) {
        String key = index + String.valueOf(next);
        if (redis.containsKey(key)) {
            return redis.get(key);
        }
        if (nums.length - 1 == index) {
            if (next) {
                return nums[index];
            } else {
                return 0;
            }
        }
        int hasNext = recursion(nums, index + 1, true);
        int notNext = recursion(nums, index + 1, false);
        if (next) {
            notNext += nums[index];
        }
        int result = hasNext < notNext ? notNext : hasNext;
        redis.put(key, result);
        return result;
    }


    private int[] trueTemp;
    private int[] falseTemp;
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        trueTemp = new int[nums.length];
        falseTemp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            trueTemp[i] = -1;
            falseTemp[i] = -1;
        }
        int hasNext = recursion(nums, 1, true);
        int notNext = recursion(nums, 1, false) + nums[0];
        return hasNext < notNext ? notNext : hasNext;
    }
    private int recursion(int[] nums, int index, boolean next) {
        if (next) {
            if (trueTemp[index] > -1) {
                return trueTemp[index];
            }
        } else {
            if (falseTemp[index] > -1) {
                return falseTemp[index];
            }
        }

        if (nums.length - 1 == index) {
            if (next) {
                return nums[index];
            } else {
                return 0;
            }
        }
        int hasNext = recursion(nums, index + 1, true);
        int notNext = recursion(nums, index + 1, false);
        if (next) {
            notNext += nums[index];
        }
        int result = hasNext < notNext ? notNext : hasNext;
        if (next) {
            trueTemp[index] = result;
        } else {
            falseTemp[index] = result;
        }
        return result;
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        House_Robber item = new House_Robber();
        int[] params = {1,2,3,1};
        System.out.println(item.rob(params));
    }
}
