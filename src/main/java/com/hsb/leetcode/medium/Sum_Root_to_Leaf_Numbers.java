package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

public class Sum_Root_to_Leaf_Numbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    public void sumNumbers(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
        }
        if (root.left == null) {
            sumNumbers(root.right, num * 10 + root.val);
            return;
        }
        if (root.right == null) {
            sumNumbers(root.left, num * 10 + root.val);
            return;
        }
        sumNumbers(root.right, num * 10 + root.val);
        sumNumbers(root.left, num * 10 + root.val);
    }
}
