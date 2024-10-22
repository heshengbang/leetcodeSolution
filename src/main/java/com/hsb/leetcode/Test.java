package com.hsb.leetcode;

import com.hsb.leetcode.entity.ListNode;

public class Test {

    public static ListNode reverse(ListNode header, int left, int right) {

        ListNode leftPre = null, leftListNode = null, rightNext = null, current = header;
        int count = 1;
        while (count <= right) {
            if (count == left - 1) {
                leftPre = current;
            }
            if (count == left) {
                leftListNode = current;
            }
            if (count == right) {
                rightNext = current.next;
                current.next = null;
                break;
            }
            count++;
            current = current.next;
        }
        current = reverse1(leftListNode, rightNext);
        if (leftPre != null) {
            leftPre.next = leftListNode;
        } else {
            return current;
        }
        return header;
    }

    private static ListNode reverse1(ListNode header, ListNode tailNext) {
        ListNode current = header;
        ListNode pre = tailNext;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] param = {3,1,4,1,5,6};
        ListNode header = ToolUtils.constructListNode(param);
        ListNode result = reverse(header, 1, 4);
        // 1 4 1 3 5 6
        ToolUtils.printListNode(result);
    }
}
