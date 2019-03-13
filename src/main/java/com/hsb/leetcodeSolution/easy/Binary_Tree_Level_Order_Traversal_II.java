package com.hsb.leetcodeSolution.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author heshengbang
 * 2019/3/13.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class Binary_Tree_Level_Order_Traversal_II {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        addList(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private void addList(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        List<Integer> item;
        if (result.size() <= level) {
            item = new ArrayList<Integer>();
        } else {
            item = result.remove(level);
        }
        item.add(node.val);
        result.add(level, item);
        addList(node.left, level + 1, result);
        addList(node.right, level + 1, result);
    }
}
