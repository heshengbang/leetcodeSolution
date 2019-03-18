package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/18 19:28
 *
 * @author heshengbang
 */

public class Minimum_Depth_of_Binary_Tree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = getDepth(node.left) + 1;
            int right = getDepth(node.right) + 1;
            return left < right ? left : right;
        }
    }
}
