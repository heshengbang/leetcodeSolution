package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

    private List<Integer> list;
    private int next;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        this.next = 0;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return list.get(next++);
    }

    public boolean hasNext() {
        return next < list.size();
    }
}
