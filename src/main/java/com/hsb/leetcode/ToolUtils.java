package com.hsb.leetcode;

import com.hsb.leetcode.entity.ListNode;
import com.hsb.leetcode.entity.TreeNode;

import java.util.ArrayDeque;

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

    public static TreeNode createTree(Integer[] arr) {
        // 使用队列来存储每一层的非空节点，下一层的数目要比上一层高
        ArrayDeque<TreeNode> pre = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        pre.addLast(root);
        // 表示要遍历的下一个节点
        int index = 0;
        while (!pre.isEmpty()) {
            ArrayDeque<TreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.removeFirst();
                TreeNode left = null;
                TreeNode right = null;
                // 如果对应索引上的数组不为空的话就创建一个节点,进行判断的时候，
                // 要先索引看是否已经超过数组的长度，如果索引已经超过了数组的长度，那么剩下节点的左右子节点就都是空了
                // 这里index每次都会增加，实际上是不必要的，但是这样写比较简单
                if (++index < arr.length && arr[index] != null) {
                    left = new TreeNode(arr[index]);
                    cur.addLast(left);
                }
                if (++index < arr.length && arr[index] != null) {
                    right = new TreeNode(arr[index]);
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            pre = cur;
        }
        return root;
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
