package com.hsb.leetcode.medium;

/**
 * @author heshengbang
 * 2019/5/14.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Add_Two_Numbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode current = null;
        boolean jw = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (jw) {
                jw = false;
                sum++;
            }
            if (sum >= 10) {
                jw = true;
                sum = sum - 10;
            }
            if (ans == null) {
                ans = new ListNode(sum);
                current = ans;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val;
            if (jw) {
                jw = false;
                sum++;
            }
            if (sum >= 10) {
                jw = true;
                sum = sum - 10;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val;
            if (jw) {
                jw = false;
                sum++;
            }
            if (sum >= 10) {
                jw = true;
                sum = sum - 10;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l2 = l2.next;
        }
        if (jw) {
            current.next = new ListNode(1);
        }
        return ans;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, current = null;
        boolean jinwei = false;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int temp = l1.val + l2.val;
            if (jinwei) {
                temp++;
            }
            if (temp >= 10) {
                jinwei = true;
                temp = temp % 10;
            } else {
                jinwei = false;
            }
            if (root == null) {
                root = new ListNode(temp);
            } else {
                if (root.next == null) {
                    root.next = new ListNode(temp);
                    current = root.next;
                } else {
                    current.next = new ListNode(temp);
                    current = current.next;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (jinwei) {
            if (root.next == null) {
                root.next = new ListNode(1);
            } else {
                current.next = new ListNode(1);
            }
        }
        return root;
    }

    private ListNode getNum(long result) {
        ListNode root = null, current = null;
        if (result == 0) {
            return new ListNode(0);
        }
        while (result != 0) {
            int rest = (int) (result % 10);
            if (root == null) {
                root = new ListNode(rest);
            } else {
                if (root.next == null) {
                    root.next = new ListNode(rest);
                    current = root.next;
                } else {
                    current.next = new ListNode(rest);
                    current = current.next;
                }
            }
            result = result / 10;
        }
        return root;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }



    public static void main(String[] args) {
        Add_Two_Numbers item = new Add_Two_Numbers();

        ListNode one = item.getNum(5);
        ListNode two = item.getNum(5);
        ListNode result = item.addTwoNumbers(two, one);
        System.out.println(result);
    }
}
