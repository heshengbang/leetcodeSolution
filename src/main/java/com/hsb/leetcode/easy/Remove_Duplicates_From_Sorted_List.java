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
Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

 */

public class Remove_Duplicates_From_Sorted_List {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, next;
        while (temp != null && temp.next != null) {
            next = temp.next;
            if (next.val == temp.val) {
                temp.next = next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(3);
//        ListNode l2 = new ListNode(3);
//        l2.next = l1;
//        ListNode l3 = new ListNode(2);
//        l3.next = l2;
        ListNode l4 = new ListNode(1);
//        l4.next = l3;

        ListNode l5 = new ListNode(1);
        l5.next = l4;

        ListNode l6 = new ListNode(1);
        l6.next = l5;

        System.out.println(deleteDuplicates(l6));
    }
}