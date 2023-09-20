package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.ListNode;

import java.net.Socket;

public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] listNodes = new ListNode[30];
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            listNodes[index] = cur;
            index++;
            cur = cur.next;
        }
        int deleteIndex = index - n;
        if (deleteIndex > 0) {
            if (deleteIndex + 1 < 30) {
                listNodes[deleteIndex - 1].next = listNodes[deleteIndex + 1];
            } else {
                listNodes[deleteIndex - 1].next = null;
            }
        } else {
            return listNodes[1];
        }
        return listNodes[0];
    }
}
