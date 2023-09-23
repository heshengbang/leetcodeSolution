package com.hsb.leetcode.medium;

import com.hsb.leetcode.entity.ListNode;

/**
 * https://blog.csdn.net/weixin_33729196/article/details/88727479
 */
public class Linked_List_Cycle_II {
    /**
     * 通过快慢指针判断是否存在环，如果不存在返回null
     * 如果存在环，慢指针从header ->  a 而快指针从 header -> a -> 若干节点 -> a
     * 那么快指针在环中多走的部分就是 若干节点 -> a 如果快指针的速度恰好是慢指针的2两倍，那么此时 这个若干节点->a其实长度和header -> a等长
     * 因此，有两个指针，一个从a出发，一个从header出发，它们交汇的第一个节点，就应该是环的头
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode slow = cur;
        ListNode quick = cur.next;
        boolean cycle = false;
        while (quick != null && quick.next != null) {
            if (slow == quick) {
                cycle = true;
                break;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        if (!cycle) {
            return null;
        }
        cur = head;
        slow = slow.next;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return slow;
    }
}
