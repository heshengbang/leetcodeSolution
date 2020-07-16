package com.hsb.leetcode.easy;

/*
 * Describe:
 * @since 2019/10/31 17:10
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        find(root1, left);
        List<Integer> right = new ArrayList<>();
        find(root2, right);
        if (left.size() != right.size()) {
            return false;
        }
        for (int i = 0; i < left.size(); i++) {
            if (!Objects.equals(left.get(i), right.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void find(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            find(root.left, list);
        }
        if (root.right != null) {
            find(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode left = ToolUtils.constructTreeNode(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode right = ToolUtils.constructTreeNode(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        Leaf_Similar_Trees item = new Leaf_Similar_Trees();
        System.out.println(item.leafSimilar(left, right));
    }
}
