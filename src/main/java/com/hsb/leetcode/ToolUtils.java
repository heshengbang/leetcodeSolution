package com.hsb.leetcode;

import com.hsb.leetcode.entity.ListNode;

/**
 * @author heshengbang
 * @version 1.0
 * @since 2019/10/22 16:32
 */

public class ToolUtils {
    public static ListNode construct(int[] array) {
        ListNode head = null;
        ListNode current = null;
        for (int item: array) {
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
}
