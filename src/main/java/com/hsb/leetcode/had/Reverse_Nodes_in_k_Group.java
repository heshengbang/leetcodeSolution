package com.hsb.leetcode.had;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Nodes in k-Group
 *
 * [1,2,3,4,5]
 * 2
 */

public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        int[] param = {1};
        ListNode head = ToolUtils.constructListNode(param);
        Reverse_Nodes_in_k_Group item = new Reverse_Nodes_in_k_Group();
        head = item.reverseKGroup(head, 1);
        ToolUtils.printListNode(head);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        int[] arr = toArray(head);
        int index = 0;
        while (index + k - 1 < arr.length) {
            reverseRangeOfArray(arr, index, index + k - 1);
            index += k;
        }
        return toListNode(arr);
    }

    private ListNode toListNode(int[] arr) {
        ListNode head = null;
        ListNode current = null;
        for (int item : arr) {
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

    private void reverseRangeOfArray(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
