package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * @version 1.0
 * @since 2019/10/22 13:54
 */

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

/**
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 *
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int deep = getDeep(head);
        if (deep == n) {
            head = head.next;
            return head;
        }
        int i = 0;
        ListNode current = head;
        while (i + 1 != deep - n) {
            current = current.next;
            i++;
        }
        current.next = current.next.next;
        return head;
    }

    public int getDeep(ListNode head) {
        if (head.next == null) {
            return 1;
        } else {
            return 1 + getDeep(head.next);
        }
    }


    public static void main(String[] args) {
        ListNode head = ToolUtils.constructListNode(new int[] {1,2,3,4,5});
        Remove_Nth_Node_From_End_of_List item = new Remove_Nth_Node_From_End_of_List();
        ListNode result = item.removeNthFromEnd(head, 2);
        System.out.println(result);
    }
}
