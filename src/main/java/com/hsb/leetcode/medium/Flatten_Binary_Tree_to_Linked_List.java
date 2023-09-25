package com.hsb.leetcode.medium;


import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (true) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
                cur.right = null;
            }
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Flatten_Binary_Tree_to_Linked_List it = new Flatten_Binary_Tree_to_Linked_List();
//        Integer[] nums = {1,2,5,3,4,null,6};
//        Integer[] nums = {};
        Integer[] nums = {0};
        TreeNode root = ToolUtils.constructTreeNode(nums);
        it.flatten(root);
        System.out.println(root.val);
    }


//    private class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
}
