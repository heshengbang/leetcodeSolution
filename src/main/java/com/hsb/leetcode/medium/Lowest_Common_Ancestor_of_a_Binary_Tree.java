package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.ListNode;
import com.hsb.leetcode.entity.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (findChild(root.left, p) && findChild(root.right, q)) {
            return root;
        } else if (findChild(root.left, q) && findChild(root.right, p)) {
            return root;
        } else if (findChild(root.left, p) && findChild(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (findChild(root.right, p) && findChild(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean findChild(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        return findChild(root.left, node) || findChild(root.right, node);
    }
}
