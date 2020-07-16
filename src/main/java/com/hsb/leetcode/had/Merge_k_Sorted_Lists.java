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
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeLists(head, lists[i]);
        }
        return head;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode head;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            head.next = mergeLists(l1.next, l2);
        } else {
            // l2 <= l1
            head = new ListNode(l2.val);
            head.next = mergeLists(l1, l2.next);
        }
        return head;
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
