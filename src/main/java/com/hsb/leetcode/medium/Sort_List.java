package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    /**
     * 对p和q之间的节点进行区分
     *  如果p和q之间的节点已经是升序的，则不用处理
     *  如果p和q之间的节点无序，则将小于p的放到p前面，大于p的放到p后面
     *  递归调用这个方法，将p.next 指向sort(p.next, q)，p.next,q之间的节点都是大于p的
     *  返回sort(header, p)之间的头节点，因为header到p之间的节点都是小于p的
     * @param p 要排序或者区分的节点的头节点
     * @param q 要排序或者区分的节点的尾部，但是不包含这个节点
     * @return 分治以后的头节点
     */
    private ListNode sort(ListNode p, ListNode q) {
        // 如果p为空或者p==q，表明待排序的节点为0，无论是不是null直接返回这个p节点即可
        if (p == null || p == q) {
            return p;
        }
        ListNode cur = p;
        // 默认有序
        boolean sorted = true;
        while (cur.next != null && cur != q) {
            if (cur.val > cur.next.val) {
                // 如果后一个节点小于前一个节点，则判定序列不对，则对其进行区分
                sorted = false;
                break;
            }
            cur = cur.next;
        }
        // p到q节点之间，都是大于p节点的
        if (sorted) {
            return p;
        } else {
            // 如果是break出来的，那么cur.next就不是null
            // 此时，p 到cur 是有序的，这之间的节点都大于p节点
            // cur到q是无序的

            // 头节点的指针
            ListNode header = p;
            ListNode pre = cur;
            cur = cur.next;
            while (cur != null && cur != q) {
                // 保存当前节点的下一个节点的引用
                ListNode next = cur.next;
                if (cur.val < p.val) {
                    // 把cur.next头插到p节点之前
                    pre.next = next;
                    cur.next = header;
                    header = cur;
                } else {
                    pre = cur;
                }
                cur = next;
            }
            // p节点把header, p之间的节点区分开了 header到p之间是小于p节点的无序节点，p.next到q节点之间是大于p节点的无序节点
            p.next = sort(p.next, q);
            return sort(header, p);
        }
    }


    /**
     * Testcases passed, but took too long.
     * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
     *
     * 这个方法是正确的，但是太慢了，题设要求时间复杂度为nlogn，但是这个方法在一个本身就是升序的链表中，时间复杂度是 n²
     *
     * https://leetcode.com/problems/sort-list
     *
     */
    public ListNode sortList1(ListNode head) {
        ListNode first = new ListNode();
        ListNode tmp = first;
        ListNode cur = head;
        while (cur != null) {
            while (cur != null && tmp.next != null) {
                if (tmp.next.val < cur.val) {
                    tmp = tmp.next;
                } else {
                    // 已排序节点的下个节点比当前节点大
                    // 记录已排序的下个节点
                    ListNode next = tmp.next;
                    // 记录未排序的下个节点
                    ListNode unsortNext = cur.next;
                    // 将当前节点插入到已排序的当前节点后面
                    tmp.next = cur;
                    // 将已排序的下个节点插入到更新后的下个节点后面
                    tmp.next.next = next;
                    // 当前节点更新为未排序的第一个节点
                    cur = unsortNext;
                    tmp = first;
                }
            }
            if (cur == null) {
                break;
            }
            // 找到尾部都没找到，则直接尾插
            tmp.next = cur;
            // 未排序节点指向下一个节点
            cur = cur.next;
            // 和未排序的断链
            tmp.next.next = null;
            // 排序节点重新回头部
            tmp = first;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = ToolUtils.constructListNode(new int[]{-1,5,3,4,0});
        Sort_List it = new Sort_List();
        ListNode result = it.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
