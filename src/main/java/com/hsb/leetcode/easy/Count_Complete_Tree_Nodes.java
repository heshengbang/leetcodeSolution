package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.TreeNode;

public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
