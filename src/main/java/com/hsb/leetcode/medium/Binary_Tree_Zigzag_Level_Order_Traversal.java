package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> levelOrder(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);
        List<List<Integer>> result = new ArrayList<>(map.values());
        for (int i = 0; i < result.size();i++) {
            if (i % 2 != 0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        dfs(root.left, level + 1);
        if (map.containsKey(level)) {
            map.get(level).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }
        dfs(root.right, level + 1);
    }
}
