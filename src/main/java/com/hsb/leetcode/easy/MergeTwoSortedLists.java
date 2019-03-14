package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode next = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        if (l1 != null) {
            next.next = l1;
        }
        if (l2 != null) {
            next.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2);
        ListNode l11 = new ListNode(1);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        System.out.println(mergeTwoLists(l11, l21));
    }
}
