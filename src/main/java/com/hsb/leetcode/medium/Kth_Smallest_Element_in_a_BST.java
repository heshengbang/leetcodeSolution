package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

import java.util.LinkedList;

public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode tmp = root;
        while (!list.isEmpty() || tmp != null) {
            while (tmp != null) {
                list.push(tmp);
                tmp = tmp.left;
            }
            tmp = list.pop();
            k--;
            if (k == 0) {
                return tmp.val;
            }
            if (tmp.right != null) {
                tmp = tmp.right;
            } else {
                tmp = null;
            }
        }
        return -1;
    }
}
