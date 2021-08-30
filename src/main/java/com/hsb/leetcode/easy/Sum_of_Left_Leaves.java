package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.TreeNode;

public class Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return findLeft(root, false);
    }

    private int findLeft(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        } else if (root.left == null) {
            return findLeft(root.right, false);
        } else if (root.right == null) {
            return findLeft(root.left, true);
        } else {
            return findLeft(root.left, true) + findLeft(root.right, false);
        }
    }


    public static void main(String[] args) {

    }
}
