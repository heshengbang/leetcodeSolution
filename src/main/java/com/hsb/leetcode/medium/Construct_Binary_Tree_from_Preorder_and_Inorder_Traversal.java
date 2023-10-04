package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return buildTree(preorder, 0, 0, inorder.length - 1, inorder);
    }

    private TreeNode buildTree(int[] preorder, int preIndex, int inStart, int inEnd, int[] inorder) {
        if (preIndex >= preorder.length) {
            return null;
        }
        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preIndex] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        if (inIndex == -1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        root.left = buildTree(preorder, preIndex + 1, inStart, inIndex - 1, inorder);
        root.right = buildTree(preorder, preIndex + 1 + inIndex - inStart, inIndex + 1, inEnd, inorder);
        return root;
    }

    int i, p;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        i = p = 0;
        return dfs(preorder, inorder, 3001);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int bound) {
        if (p == preorder.length || inorder[i] == bound) return null;
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = dfs(preorder, inorder, node.val);
        i++;
        node.right = dfs(preorder, inorder, bound);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal it = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode root = it.buildTree1(preorder, inorder);
        System.out.println(root);
    }
}
