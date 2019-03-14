package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/14 8:59
 *
 * @author heshengbang
 */

/**
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return insertNode(nums, 0, nums.length - 1);
    }

    private TreeNode insertNode(int[] nums, int begin, int end) {
        if (end < begin || begin < 0 || begin >= nums.length || end >= nums.length) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(begin);
        }
        int middle = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = insertNode(nums, begin, middle - 1);
        root.right = insertNode(nums, middle + 1, end);
        return root;
    }
}