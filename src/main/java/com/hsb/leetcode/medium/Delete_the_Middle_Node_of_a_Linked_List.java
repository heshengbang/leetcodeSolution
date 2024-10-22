package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Delete_the_Middle_Node_of_a_Linked_List {
    public ListNode deleteMiddle(ListNode head) {
        ListNode cur = head;
        int count = -1;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int middle;
        if (count % 2 == 0) {
            middle = count / 2;
        } else {
            middle = (count / 2) + 1;
        }
        if (middle == 0) {
            return null;
        }
        cur = head;
        count = 0;
        while (true) {
            if (count + 1 == middle && cur.next != null) {
                cur.next = cur.next.next;
                break;
            } else {
                count++;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ToolUtils.constructListNode(new int[] {1});
        Delete_the_Middle_Node_of_a_Linked_List it = new Delete_the_Middle_Node_of_a_Linked_List();
        System.out.println(it.deleteMiddle(node));
    }
}
