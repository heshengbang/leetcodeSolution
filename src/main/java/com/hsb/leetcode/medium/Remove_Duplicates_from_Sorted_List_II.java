package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = null;
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            int count = 1;
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                count++;
            }
            if (current.next == null) {
                if (count == 1) {
                    if (first == null) {
                        first = current;

                    }
                    if (pre != null) {
                        pre.next = current;
                    }
                }
                current = null;
            } else if (current.val != current.next.val) {
                if (count == 1) {
                    ListNode next = current.next;
                    if (first == null) {
                        first = current;
                        first.next = null;
                        pre = first;
                    } else {
                        pre.next = current;
                        pre.next.next = null;
                        pre = current;
                    }
                    current = next;
                } else {
                    current = current.next;
                }
            }
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode head = ToolUtils.constructListNode(new int[]{1, 2, 2});
        Remove_Duplicates_from_Sorted_List_II it = new Remove_Duplicates_from_Sorted_List_II();
        System.out.println(it.deleteDuplicates(head));
    }
}
