package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

/**
 * @version 1.0
 * @since 2020/7/24 16:39
 */

public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head, next = head.next, pre = null;
        head = next;
        while (true) {
            current.next = next.next;
            next.next = current;
            if (pre != null) {
                pre.next = next;
            }
            if (current.next == null) {
                break;
            }
            pre = current;
            current = current.next;
            if (current.next == null) {
                break;
            }
            next = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ToolUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        Swap_Nodes_in_Pairs item = new Swap_Nodes_in_Pairs();
        System.out.println(item.swapPairs(head));
    }
}
