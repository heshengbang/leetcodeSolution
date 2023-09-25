package com.hsb.leetcode.had;

/*
 * 类描述:
 * Copyright trulyheshengbang@gmail.com
 * @since 2019/7/3 14:15
 * @version 1.0
 * @author heshengbang
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
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 1 && n == 0) {
            return nums1[0];
        } else if (m == 0 && n == 1) {
            return nums2[0];
        } else if (m == 1 && n == 1) {
            return (Double.valueOf(nums1[0]) + Double.valueOf(nums2[0])) / 2;
        } else if (m == 2 && n == 0) {
            return (Double.valueOf(nums1[0]) + Double.valueOf(nums1[1])) / 2;
        } else if (m == 0 && n == 2) {
            return (Double.valueOf(nums2[0]) + Double.valueOf(nums2[1])) / 2;
        }

        if (m == 0) {
            int[] copy = new int[n - 2];
            System.arraycopy(nums2, 1, copy, 0, n - 2);
            return findMedianSortedArrays(nums1, copy);
        } else if (n == 0) {
            int[] copy = new int[m - 2];
            System.arraycopy(nums1, 1, copy, 0, m - 2);
            return findMedianSortedArrays(copy, nums2);
        }

        if (nums1[0] < nums2[0]) {
            if (nums1[m - 1] < nums2[n - 1]) {
                int[] c1 = new int[m - 1];
                int[] c2 = new int[n - 1];
                System.arraycopy(nums1, 1, c1, 0, m - 1);
                System.arraycopy(nums2, 0, c2, 0, n - 1);
                return findMedianSortedArrays(c1, c2);
            } else {
                int[] copy = new int[m - 2];
                System.arraycopy(nums1, 1, copy, 0, m - 2);
                return findMedianSortedArrays(copy, nums2);
            }
        } else {

            if (nums1[m - 1] < nums2[n - 1]) {
                int[] copy = new int[n - 2];
                System.arraycopy(nums2, 1, copy, 0, n - 2);
                return findMedianSortedArrays(nums1, copy);
            } else {
                int[] c1 = new int[m - 1];
                int[] c2 = new int[n - 1];
                System.arraycopy(nums1, 0, c1, 0, m - 1);
                System.arraycopy(nums2, 1, c2, 0, n - 1);
                return findMedianSortedArrays(c1, c2);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1,2,3,4};

        Median_of_Two_Sorted_Arrays it = new Median_of_Two_Sorted_Arrays();
        System.out.println(it.findMedianSortedArrays2(nums1, nums2));
    }






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
}
