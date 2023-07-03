package com.hsb.leetcode.easy;

import java.util.Arrays;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 */

public class Merge_Sorted_Array {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n - 1, i = m -1;
        while (i >= 0 || j >= 0) {
            while (j >= 0 && (i < 0 || nums1[i] < nums2[j])) {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
            while (i >= 0 && (j < 0 || nums1[i] >= nums2[j])) {
                nums1[i + j + 1] = nums1[i];
                i--;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        System.out.println(Arrays.toString(merge1(nums1, 1, nums2, 0)));


//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;
//        System.out.println(Arrays.toString(merge1(nums1, m, nums2, n)));


//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
//        System.out.println(Arrays.toString(merge1(nums1, m, nums2, n)));

//        int[] nums1 = {2, 0};
//        int m = 1;
//        int[] nums2 = {1};
//        int n = 1;
//        System.out.println(Arrays.toString(merge1(nums1, m, nums2, n)));
    }


    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else if (n == 0) {
            // do nothing
        } else {
            int j = n - 1;
            int count = m + n -1;
            for (int i = m - 1;i >= 0 && j >= 0 && count >= 0;) {
                if (nums1[i] > nums2[j]) {
                    nums1[count] = nums1[i];
                    i--;
                    if (i < 0) {
                        System.arraycopy(nums2, 0, nums1, 0, count);
                        break;
                    }
                } else {
                    nums1[count] = nums2[j];
                    j--;
                    if (j < 0) {
                        break;
                    }
                }
                count--;
            }
        }
        return nums1;
    }
}