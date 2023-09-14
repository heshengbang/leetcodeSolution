package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/4/24.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */


public class Linked_List_Cycle {

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode next = head;
        ListNode nn = null;
        if (next != null) {
            nn = next.next;
        }
        while (next != null && nn != null) {
            if (next == nn) {
                return true;
            } else {
                next = next.next;
                nn = null;
                if (next != null) {
                    nn = next.next;
                }
            }
        }
        return false;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
