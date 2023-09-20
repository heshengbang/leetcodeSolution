package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/12/10 21:01
 * @version 1.0
 */

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;
import com.hsb.leetcode.entity.TreeNode;

import java.util.Stack;

public class Invert_Binary_Tree {

    public TreeNode invertTreeNoRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Integer[] arryas = {4, 2, 7, 1, 3, 6, 9};
        TreeNode treeNode = ToolUtils.constructTreeNode(arryas);
        TreeNode result = new Invert_Binary_Tree().invertTree(treeNode);
        System.out.println(result);
    }
}
