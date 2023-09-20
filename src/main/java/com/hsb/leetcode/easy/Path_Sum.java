package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/3/18.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

import com.hsb.leetcode.entity.TreeNode;

/**
 * Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int rest = targetSum - root.val;
        if (root.left == null) {
            return hasPathSum(root.right, rest);
        }
        if (root.right == null) {
            return hasPathSum(root.left, rest);
        }
        return hasPathSum(root.right, rest) || hasPathSum(root.left, rest);
    }
}
