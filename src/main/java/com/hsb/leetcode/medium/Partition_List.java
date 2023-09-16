package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHeader = null;
        ListNode lessTail = null;
        ListNode goeHeader = null;
        ListNode goeTail = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            if (current.val < x) {
                if (lessHeader == null) {
                    lessHeader = current;
                } else {
                    lessTail.next = current;
                }
                lessTail = current;
                if (goeHeader != null) {
                    lessTail.next = goeHeader;
                }
            } else {
                if (goeHeader == null) {
                    goeHeader = current;
                    goeTail = current;
                    if (lessTail != null) {
                        lessTail.next = goeHeader;
                    }
                } else {
                    goeTail.next = current;
                    goeTail = current;
                }
            }
            current = next;
        }
        if (lessTail != null) {
            lessTail.next = goeHeader;
            return lessHeader;
        } else {
            return goeHeader;
        }

    }


    public static void main(String[] args) {
        ListNode header = ToolUtils.constructListNode(new int[]{1});

        Partition_List it = new Partition_List();
        System.out.println(it.partition(header, 0));
    }
}
