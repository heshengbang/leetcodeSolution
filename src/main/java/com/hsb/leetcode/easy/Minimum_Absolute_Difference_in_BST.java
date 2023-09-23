package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Absolute_Difference_in_BST {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        int left = getMinimumDifference(root.left, list);
        int right = getMinimumDifference(root.right, list);
        return Math.min(left, right);
    }

    private int getMinimumDifference(TreeNode root, List<Integer> list) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int cur = Integer.MAX_VALUE;
        for (Integer integer: list) {
            cur = Math.min(cur, Math.abs(integer - root.val));
        }
        list.add(root.val);
        int left = getMinimumDifference(root.left, list);
        int right = getMinimumDifference(root.right, list);
        cur = Math.min(left, cur);
        cur = Math.min(right, cur);
        return cur;
    }
}
