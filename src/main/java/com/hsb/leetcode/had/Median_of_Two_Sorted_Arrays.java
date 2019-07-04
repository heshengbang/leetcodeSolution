package com.hsb.leetcode.had;

/*
 * 类描述:
 * Copyright 多点生活（成都）科技有限公司
 * @since 2019/7/3 14:15
 * @version 1.0
 * @author hu.he@dmall.com 何虎
 *************************************************
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] nums = new int[total];
        int i = 0, j = 0, k = 0;
        while (k < total) {
            if (i >= nums1.length) {
                nums[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                nums[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (total % 2 == 0) {
            int middle1 = total / 2;
            int middle2 = middle1 + 1;
            return (double)(nums[middle1 - 1] + nums[middle2 - 1]) / 2;
        } else {
            int middle = (total + 1) / 2;
            return nums[middle - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, -1};
        int[] nums2 = {3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
