package com.hsb.leetcode.medium;

import java.util.Arrays;

public class Rotate_Array {
    public static void rotate1(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            return;
        }
        int rotate = k % nums.length;
        if (rotate == 0) {
            return;
        }
        int[] map = new int[nums.length * 2];
        for (int i = 0; i < nums.length;i++) {
            map[i] = nums[i];
            map[i + nums.length] = nums[i];
        }
        int start = nums.length - rotate;
        int end = nums.length * 2 - rotate;

        for (int i = start, j = 0; i < end; i++, j++) {
            nums[j] = map[i];
        }
    }

    /**
     * solution with bad space usage
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (nums.length < 2 || k < 1) {
            return;
        }
        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, k);
    }


    public static void rotate3(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (nums.length < 2 || k == 0) {
            return;
        }
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        int tmp;
        for (int i = start, j = end; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
//        int[] param = {1, 2};
//        rotate2(param, 3);
//        System.out.println(Arrays.toString(param));


//        int[] param = {1,2,3,4,5,6,7};
//        rotate3(param, 3);
//        System.out.println(Arrays.toString(param));

//        int[] param = {-1,-100,3,99};
//        rotate3(param, 2);
//        System.out.println(Arrays.toString(param));

        int[] param = {1, 2};
        rotate3(param, 3);
        System.out.println(Arrays.toString(param));
    }
}
