package com.hsb.leetcode.medium;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArrayII it = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(it.removeDuplicates(nums));

//        int[] nums = {0,0,1,1,1,1,2,3,3};
//        RemoveDuplicatesFromSortedArrayII it = new RemoveDuplicatesFromSortedArrayII();
//        System.out.println(it.removeDuplicates(nums));
    }

    private int removeDuplicates(int[] nums) {
        int count = 0;
        int current = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != current) {
                current = nums[i];
                nums[count] = current;
                count++;
                if (i + 1 < nums.length && nums[i + 1] == current) {
                    nums[count] = current;
                    i++;
                    count++;
                } else {
                    continue;
                }
            }
        }
        return count;
    }
}
