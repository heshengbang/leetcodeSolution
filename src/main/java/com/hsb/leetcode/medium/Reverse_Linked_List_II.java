package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode[] mem = new ListNode[right + 2];
        int middle = (right + left) / 2;
        if ((right + left) % 2 != 0) {
            middle++;
        }

        int index = 1;
        ListNode cur = head;
        while (index < right + 2 && cur != null) {
            mem[index] = cur;
            ListNode next = cur.next;
            if (middle <= right && index == middle) {
                int changeIndex = (right - middle) + left;
                // 不是同一个节点的时候交换
                if (changeIndex != index) {
                    // 交换
                    ListNode tmp = mem[changeIndex];
                    mem[changeIndex] = mem[index];
                    mem[index] = tmp;
                    // 构建前后关系
                    if (mem[changeIndex - 1] != null && changeIndex > 0) {
                        mem[changeIndex - 1].next = mem[changeIndex];
                    }
                    if (changeIndex < right) {
                        mem[changeIndex].next = mem[changeIndex + 1];
                    }
                    // 构建前一个对后一个的链接关系
                    if (mem[index - 1] != null && index > 0) {
                        mem[index - 1].next = mem[index];
                    }
                    // 此时它后面还没有值
//                if (index <= right) {
//                    mem[index].next = mem[index + 1];
//                }
                }
                middle++;
            }
            cur = next;
            index++;
        }
        if (mem[right] != null) {
            mem[right].next = mem[right + 1];
        }
        return mem[1];
    }

    private ListNode reverseII(ListNode head, int left, int right) {
        ListNode leftPre = null, leftNode = null, rightNext = null;
        int index = 1;
        ListNode current = head;
        while (current != null) {
            if (index == left - 1) {
                leftPre = current;
            }
            if (index == left) {
                leftNode = current;
            }
            if (index == right) {
                rightNext = current.next;
                current.next = null;
                break;
            }
            index++;
            current = current.next;
        }
        current = reverse(leftNode, rightNext);
        if (leftPre != null) {
            leftPre.next = current;
        } else {
            return current;
        }
        return head;
    }

    private ListNode reverse(final ListNode header, final ListNode tailNext) {
        ListNode pre = tailNext, current = header;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode header = ToolUtils.constructListNode(new int[]{3,1,4,1,5,6});
        Reverse_Linked_List_II it = new Reverse_Linked_List_II();
        ToolUtils.printListNode(it.reverseII(header, 1, 4));
    }
}
