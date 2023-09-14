package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.right == null) {
            return Collections.singletonList(root.val);
        }
        TreeNode tmp = root;
        while (tmp != null) {
            result.add(tmp.val);
            tmp = tmp.right;
        }
        return result;
    }
}
