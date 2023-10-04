package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        } else if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        return buildTree(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int pIndex, int[] inorder, int istart, int iend) {
        if (pIndex < 0 || istart > iend) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pIndex]);
        int tmp = -1;
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == node.val) {
                tmp = i;
                break;
            }
        }
        node.right = buildTree(postorder, pIndex - 1, inorder, tmp + 1, iend);
        node.left = buildTree(postorder, pIndex - 1 - (iend - tmp), inorder, istart, tmp - 1);
        return node;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<List<Integer>> stack = new Stack<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        stack.push(toList(inorder, 0, inorder.length - 1));
        int p = postorder.length - 1;
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            if (list.size() == 1) {
                treeNodes.push(new TreeNode(list.get(0)));
                p--;
                continue;
            }
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            boolean findRoot = false;
            for (int i = 0; i < list.size(); i++) {
                if (postorder[p--] == inorder[i]) {
                    findRoot = true;
                    TreeNode root = new TreeNode(inorder[i]);
                    treeNodes.push(root);
                    continue;
                }
                if (!findRoot) {
                    left.add(list.get(i));
                } else {
                    right.add(list.get(i));
                }
            }
            if (left.size() > 0) {
                stack.push(left);
            }
            if (right.size() > 0) {
                stack.push(right);
            }
        }
        return null;
    }

    private List<Integer> toList(int[] inorder, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(inorder[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal it = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        TreeNode node = it.buildTree1(inorder, postorder);
        System.out.println(node.val);
    }
}
