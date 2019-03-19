package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/19 8:52
 *
 * @author heshengbang
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class Path_Sum_II {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root != null) {
            dfs(root, sum, results, path);
        }
        return results;
    }

    /**
     * 深度优先搜索算法
     * @param node 待搜索节点
     * @param sum 路径值之和
     * @param results 符合条件的路径
     * @param path 当前已经走过的路径
     */
    private void dfs(TreeNode node, int sum, List<List<Integer>> results, List<Integer> path) {
        if (node != null) {
            if (node.left == null && node.right == null && node.val == sum) {
                path.add(node.val);
                results.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            } else {
                path.add(node.val);
                dfs(node.left, sum - node.val, results, path);
                dfs(node.right, sum - node.val, results, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
