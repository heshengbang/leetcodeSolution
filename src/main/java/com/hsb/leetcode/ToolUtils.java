package com.hsb.leetcode;

import com.hsb.leetcode.entity.ListNode;
import com.hsb.leetcode.entity.TreeNode;

/**
 * @author heshengbang
 * @version 1.0
 * @since 2019/10/22 16:32
 */

public class ToolUtils {
    public static ListNode constructListNode(int[] array) {
        ListNode head = null;
        ListNode current = null;
        for (int item : array) {
            if (current == null) {
                head = new ListNode(item);
                current = head;
            } else {
                ListNode next = new ListNode(item);
                current.next = next;
                current = next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode param) {
        while (param != null) {
            System.out.print(param.val + " ");
            param = param.next;
        }
        System.out.println();
    }

    public static TreeNode constructTreeNode(Integer[] array) {
        return createBinaryTreeByArray(array, 0);
    }

    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode node = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            node = new TreeNode(value);
            node.left = createBinaryTreeByArray(array, 2 * index + 1);
            node.right = createBinaryTreeByArray(array, 2 * index + 2);
            return node;
        }
        return node;
    }
}
