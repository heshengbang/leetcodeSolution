package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Recover Binary Search Tree
 */

public class Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();

        TreeNode cur = root, pre;
        while (cur != null) {
            if (cur.left == null) {
                values.add(cur.val);
                nodes.add(cur);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    values.add(cur.val);
                    nodes.add(cur);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        Collections.sort(values);
        for (int i = 0; i < values.size(); i++) {
            nodes.get(i).val = values.get(i);
        }
    }


    /**
     * with n(1) space solution
     * @param root
     */
    public static void recoverTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            TreeNode biggest = findBig(root.left);
            TreeNode smallest = findSmall(root.right);
            if (biggest.val < root.val && root.val < smallest.val) {
                recoverTree1(root.left);
                recoverTree1(root.right);
            } else if (smallest.val < root.val && root.val < biggest.val) {
                swap(smallest, biggest);
            } else if (root.val < biggest.val) {
                swap(root, biggest);
            } else if (smallest.val < root.val) {
                swap(smallest, root);
            }
        } else if (root.left != null) {
            TreeNode biggest = findBig(root.left);
            if (biggest.val <= root.val) {
                recoverTree1(root.left);
            } else {
                swap(biggest, root);
            }
        } else if (root.right != null) {
            TreeNode smallest = findSmall(root.right);
            if (root.val <= smallest.val) {
                recoverTree1(root.right);
            } else {
                swap(root, smallest);
            }
        }
    }

    private static void swap(TreeNode t1, TreeNode t2) {
        int tmp  = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    private static TreeNode findSmall(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left != null && root.right != null) {
            TreeNode left =findSmall(root.left);
            TreeNode right = findSmall(root.right);
            TreeNode tmp = left.val <= right.val ? left : right;
            return tmp.val < root.val ? tmp : root;
        } else if (root.left != null) {
            TreeNode left =findSmall(root.left);
            return left.val < root.val ? left : root;
        } else if (root.right != null) {
            TreeNode right = findSmall(root.right);
            return right.val < root.val ? right : root;
        }
        return null;
    }

    private static TreeNode findBig(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            TreeNode left =findBig(root.left);
            TreeNode right = findBig(root.right);
            TreeNode tmp = left.val <= right.val ? right : left;
            return tmp.val < root.val ? root : tmp;
        } else if (root.left != null) {
            TreeNode left =findBig(root.left);
            return left.val < root.val ? root : left;
        } else if (root.right != null) {
            TreeNode right = findBig(root.right);
            return right.val < root.val ? root : right;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] param = {1,3,null,null,2};
        TreeNode root = ToolUtils.constructTreeNode(param);
        recoverTree1(root);
        System.out.println(root.val);
    }
}
