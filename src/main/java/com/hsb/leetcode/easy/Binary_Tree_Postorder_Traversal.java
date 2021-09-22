package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 */

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> src = new Stack<>();
        res.push(root);
        while (!res.isEmpty()) {
            TreeNode current = res.pop();
            src.push(current);
            if (current.left != null) {
                res.push(current.left);
            }
            if (current.right != null) {
                res.push(current.right);
            }
        }
        while (!src.isEmpty()) {
            result.add(src.pop().val);
        }
        return result;
    }
}
