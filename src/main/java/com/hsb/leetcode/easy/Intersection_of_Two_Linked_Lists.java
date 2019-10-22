package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/4/25.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

import com.hsb.leetcode.entity.ListNode;

/**
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB;
        while (tempA != null) {
            tempB = headB;
            while (tempB != null) {
                if (equals(tempA, tempB)) {
                    return tempB;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }

    public boolean equals(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null && nodeB == null) {
            return true;
        } else if (nodeA == null || nodeB == null) {
            return false;
        } else {
            while (nodeA != null && nodeB != null && nodeA.val == nodeB.val) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return nodeA == null && nodeB == null;
        }
    }

    public static void main(String[] args) {
        Intersection_of_Two_Linked_Lists example = new Intersection_of_Two_Linked_Lists();
        ListNode headA = example.construct(new int[]{4,1,8,4,5});
        ListNode headB = example.construct(new int[]{5,0,1,8,4,5});
        example.getIntersectionNode(headA, headB);
    }

    public ListNode construct(int[] array) {
        ListNode head = null, current, preOne = null;
        for (int i = 0; i < array.length; i++) {
            current = new ListNode(array[i]);
            if (head == null) {
                head = current;
                preOne = current;
            } else {
                preOne.next = current;
                preOne = preOne.next;
            }
        }
        return head;
    }
}