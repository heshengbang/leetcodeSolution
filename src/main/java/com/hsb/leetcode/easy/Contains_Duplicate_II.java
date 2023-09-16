package com.hsb.leetcode.easy;

/*
 * @since 2019/12/26 22:16
 * @version 1.0
 * @author heshengbang
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return false;
        }
        for(int i = 0; i < nums.length ; i++ ){
            int temp = i + k;
            while(i < temp){
                if(temp < nums.length && nums[i] == nums[temp]){
                    return true;
                }
                temp--;
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                for (int it: list) {
                    if (Math.abs(i - it) <= k) {
                        return true;
                    }
                }
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
        return false;
    }



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
        int[] arrays = {1,2,3,1,2,3};
        Contains_Duplicate_II item = new Contains_Duplicate_II();
        System.out.println(item.containsNearbyDuplicate2(arrays, 2));
    }
}
