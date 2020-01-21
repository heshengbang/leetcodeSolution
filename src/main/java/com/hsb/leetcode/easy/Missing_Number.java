package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/1/21 17:06
 */

public class Missing_Number {
    public int missingNumber(int[] nums) {
        boolean[] records = new boolean[nums.length];
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            records[num - 1] = true;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!records[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber1(int[] nums) {
        int sum = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (i + 1) * (i) / 2 - sum;
    }

    public static void main(String[] args) {
        Missing_Number item = new Missing_Number();
        int[] param = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(item.missingNumber1(param));
    }
}
