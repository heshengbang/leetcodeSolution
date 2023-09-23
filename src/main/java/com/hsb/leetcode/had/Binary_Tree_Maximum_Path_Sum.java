package com.hsb.leetcode.had;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

public class Binary_Tree_Maximum_Path_Sum {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxPath;
    }

    private int findMaxPath(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftSum = Integer.MIN_VALUE;
        if (root.left != null) {
            leftSum = Math.max(leftSum, findMaxPath(root.left));
        }
        int rightSum = Integer.MIN_VALUE;
        if (root.right != null) {
            rightSum = Math.max(rightSum, findMaxPath(root.right));
        }
        int sum;
        if (root.val < 0) {
            if (leftSum < 0) {
                if (rightSum < 0) {
                    maxPath = Math.max(maxPath, rightSum);
                    maxPath = Math.max(maxPath, leftSum);
                    maxPath = Math.max(maxPath, root.val);

                    sum = root.val;
                } else {
                    maxPath = Math.max(maxPath, rightSum);

                    sum = root.val + rightSum;
                }
            } else {
                if (rightSum < 0) {
                    sum = root.val + leftSum;
                    maxPath = Math.max(maxPath, leftSum);
                } else {
                    maxPath = Math.max(maxPath, Math.max(leftSum, rightSum));
                    maxPath = Math.max(maxPath, leftSum + rightSum + root.val);

                    sum = root.val + Math.max(leftSum, rightSum);
                }
            }
        } else {
            if (leftSum < 0) {
                if (rightSum < 0) {
                    maxPath = Math.max(maxPath, root.val);

                    sum = root.val;
                } else {
                    maxPath = Math.max(maxPath, rightSum + root.val);

                    sum = root.val + rightSum;
                }
            } else {
                if (rightSum < 0) {
                    maxPath = Math.max(maxPath, leftSum + root.val);

                    sum = root.val + leftSum;
                } else {
                    maxPath = Math.max(maxPath, leftSum + rightSum + root.val);

                    sum = root.val + Math.max(leftSum, rightSum);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] nums = {-1,8,2,null,-9,0,null,null,null,-3,null,null,-9,null,2};
        TreeNode root = ToolUtils.constructTreeNode(nums);

        Binary_Tree_Maximum_Path_Sum it = new Binary_Tree_Maximum_Path_Sum();
        System.out.println(it.maxPathSum(root));


    }
}
