package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.ListNode;

/**
 * Reverse Linked List
 * @author yunsh
 */

public class Reverse_Linked_List {
    public static void main(String[] args) {

    }

    private ListNode reverse(final ListNode header) {
        ListNode pre = null, current = header;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }


    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-5001), pre = dummy, cur = pre;
        dummy.next = head;
        while ((pre = dummy.next) != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}
