package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Rotate_List {
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = head;
        int rest = k % count;
        int forNum = count - rest;
        current = head;
        for (int i = 0; i <= forNum; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int count = list.size();
        int actualRotate = k % count;
        if (actualRotate == 0) {
            return head;
        }
        int[] map = new int[count * 2];
        for (int i = 0; i < map.length; i++) {
            map[i] = list.get(i % list.size());
        }
        ListNode result = null, pre = null;
        int start = count - actualRotate;
        int end = count * 2 - actualRotate;
        for (int i = start; i < end; i++) {
            cur = new ListNode(map[i]);
            if ( i == start) {
                result = cur;
            } else {
                pre.next = cur;
            }
            pre = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] param = {1,2};
        ListNode result = rotateRight(ToolUtils.constructListNode(param), 0);
        ToolUtils.printListNode(result);
    }
}
