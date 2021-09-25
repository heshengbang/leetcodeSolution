package com.hsb.leetcode.medium;

/*
 * Unique Binary Search Trees II
 */

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unique_Binary_Search_Trees_II {

    public static void main(String[] args) {
        Unique_Binary_Search_Trees_II item = new Unique_Binary_Search_Trees_II();
        List<TreeNode> list = item.generateTrees(3);
        System.out.println(list);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list = insert(list, i);
        }
        return list;
    }

    private List<TreeNode> insert(List<TreeNode> list, int val) {
        if (list.size() == 0) {
            return Arrays.asList(new TreeNode(val));
        }
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode item : list) {
            result.addAll(insertVal(item, val));
        }
        return result;
    }

    private List<TreeNode> insertVal(TreeNode node, int val) {
        List<TreeNode> result = new ArrayList<>();

        if (findBiggest(node) < val) {
            TreeNode head = new TreeNode(val);
            head.left = node;
            result.add(head);
        }

        if (val < findSmallest(node)) {
            TreeNode head = new TreeNode(val);
            head.right = node;
            result.add(head);
        }

        result.add(insertAsChild(node, val));


        return result;
    }

    private TreeNode insertAsChild(TreeNode head, int val) {
        TreeNode node = head;
        while (true) {
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return head;
                }
                node = node.right;
            }
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                }
                node = node.left;
            }
        }
    }

    private int findSmallest(TreeNode node) {
        TreeNode tmp = node;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.val;
    }

    private int findBiggest(TreeNode node) {
        TreeNode tmp = node;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.val;
    }
}
