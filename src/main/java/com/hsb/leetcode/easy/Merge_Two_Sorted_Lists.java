package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.ListNode;

public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, current = null;
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode next = list1.next;
                if (head == null) {
                    head = list1;
                } else {
                    current.next = list1;
                }
                current = list1;
                list1 = next;
            } else {
                ListNode next = list2.next;
                if (head == null) {
                    head = list2;
                } else {
                    current.next = list2;
                }
                current = list2;
                list2 = next;
            }
        }
        if (list1 == null && list2 != null) {
            current.next = list2;
        }
        if (list2 == null && list1 != null) {
            current.next = list1;
        }
        return head;
    }
}
