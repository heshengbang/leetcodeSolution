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
        if (nums1[nums1.length - 1] < nums2[0]) {
            // nums1整体在nums2左边
        }
        if (nums2[nums2.length - 1] < nums1[0]) {

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, -2};
        int[] nums2 = {3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
