package com.hsb.leetcode.easy;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;
import com.hsb.leetcode.entity.TreeNode;

public class Minimum_Distance_Between_BST_Nodes {

    /**
     * 题目中给的树是一个二叉搜索树，所以隐含条件就是，左子树的所有节点的值都应该小于根节点，右子树的所有节点的值都应该小于根节点
     * 如果把这个二叉搜索树按照中序遍历转换为数组，那么就应该是一个递增的有序数组
     * 所以，按照中序遍历的时候，只需要关心根节点和它的左右节点之间的差值是否足够小就行了，不需要关心祖父节点和孙子节点之间的差值
     * 因此，按照中序遍历对树进行递归搜索即可
     */
    int result = Integer.MAX_VALUE;
    TreeNode last = new TreeNode(-1);
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (last.val >= 0) {
            result = Math.min(result, Math.abs(last.val - root.val));
        }
        last = root;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return result;
    }


    public static void main(String[] args) {
        Integer[] array = {1,0,48,null,null,12, 49};
        TreeNode root = ToolUtils.constructTreeNode(array);
        Minimum_Distance_Between_BST_Nodes it = new Minimum_Distance_Between_BST_Nodes();
        System.out.println(it.minDiffInBST(root));
    }
}
