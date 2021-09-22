package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

/**
 * Validate Binary Search Tree
 */

public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        if (root.left != null && root.right != null) {
            TreeNode biggest = findBig(root.left);
            TreeNode smallest = findSmall(root.right);
            if (biggest.val < root.val && root.val < smallest.val) {
                return isValidBST(root.left) && isValidBST(root.right);
            } else {
                return false;
            }
        } else if (root.left != null) {
            TreeNode biggest = findBig(root.left);
            if (biggest.val < root.val) {
                return isValidBST(root.left);
            } else {
                return false;
            }
        } else if (root.right != null) {
            TreeNode smallest = findSmall(root.right);
            if (root.val < smallest.val) {
                return isValidBST(root.right);
            } else {
                return false;
            }
        } else {
            return true;
        }
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


    public boolean isValidBST1(TreeNode root) {
        return validBST(root, null, null);
    }

    private boolean validBST(TreeNode root, Integer small, Integer big) {
        if (root == null) {
            return true;
        }
        if ((small != null && root.val <= small) || (big != null && big <= root.val)) {
            return false;
        } else {
            return validBST(root.left, small, root.val) && validBST(root.right, root.val, big);
        }
    }

    public static void main(String[] args) {
        Validate_Binary_Search_Tree item = new Validate_Binary_Search_Tree();
        Integer[] param = {1, 1};
        System.out.println(item.isValidBST(ToolUtils.constructTreeNode(param)));
    }
}
