package com.hsb.leetcode.entity;

/*
 * Describe:
 * @since 2019/10/31 17:09
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import com.hsb.leetcode.medium.Populating_Next_Right_Pointers_in_Each_Node_II;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
