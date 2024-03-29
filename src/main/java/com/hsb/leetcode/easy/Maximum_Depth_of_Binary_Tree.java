package com.hsb.leetcode.easy;


/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*

Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

 */

public class Maximum_Depth_of_Binary_Tree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 0;
        if (root.left != null) {
            left = maxDepth1(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = maxDepth1(root.right);
        }
        return (right > left ? right : left) + 1;
    }


    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left < right ? right : left);
    }

    public static void main(String[] args) {

    }
}
