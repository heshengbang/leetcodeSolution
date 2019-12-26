package com.hsb.leetcode.easy;

/*
 * @since 2019/12/26 22:16
 * @version 1.0
 * @author heshengbang
 */

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int mostDiff = 0, diff;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length;j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                diff = j - i;
                if (mostDiff == 0) {
                    mostDiff = diff;
                } else if (mostDiff > diff) {
                    mostDiff = diff;
                }
            }
        }
        return mostDiff != 0 && k >= mostDiff;
    }

    public static void main(String[] args) {
        int[] arrays = {1,2};
        Contains_Duplicate_II item = new Contains_Duplicate_II();
        System.out.println(item.containsNearbyDuplicate(arrays, 1));
    }
}
