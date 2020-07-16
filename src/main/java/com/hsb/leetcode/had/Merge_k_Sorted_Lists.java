package com.hsb.leetcode.had;

/*
 * 类描述:
 * @since 2019/11/18 13:13
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                // l2 <= l1
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        if (l1 != null) {
            next.next = l1;
        } else {
            next.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ToolUtils.constructListNode(new int[]{1, 4, 5});
        ListNode[] params = new ListNode[3];
        params[0] = listNode1;
        ListNode listNode2 = ToolUtils.constructListNode(new int[]{1, 3, 4});
        params[1] = listNode2;
        ListNode listNode3 = ToolUtils.constructListNode(new int[]{2, 6});
        params[2] = listNode3;
        Merge_k_Sorted_Lists executor = new Merge_k_Sorted_Lists();
        ListNode result = executor.mergeKLists(params);
        ToolUtils.printListNode(result);
    }
}
