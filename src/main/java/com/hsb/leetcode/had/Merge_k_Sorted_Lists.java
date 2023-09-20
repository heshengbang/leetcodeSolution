package com.hsb.leetcode.had;

/*
 * 类描述:
 * @since 2019/11/18 13:13
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

public class Merge_k_Sorted_Lists {
    /**
     * 两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
            return mergeList(lists[0], lists[1]);
        }
        int length = lists.length;
        while (length > 1) {
            ListNode[] tmp;
            if (length % 2 == 0) {
                tmp = new ListNode[length / 2];
                for (int i = 0; i < length - 1; i = i + 2) {
                    tmp[i / 2] = mergeList(lists[i], lists[i + 1]);
                }
            } else {
                tmp = new ListNode[(length / 2) + 1];
                for (int i = 0; i < length - 2;  i = i + 2) {
                    tmp[i / 2] = mergeList(lists[i], lists[i + 1]);
                }
                tmp[length / 2] = lists[length - 1];
            }
            lists = tmp;
            length = tmp.length;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode tmp = null, header = null, next;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                next = l1.next;
                if (tmp == null) {
                    header = l1;
                } else {
                    tmp.next = l1;
                }
                tmp = l1;
                l1 = next;
            } else {
                next = l2.next;
                if (tmp == null) {
                    header = l2;
                } else {
                    tmp.next = l2;
                }
                tmp = l2;
                l2 = next;
            }
        }
        if (l1 != null) {
            if (tmp != null) {
                tmp.next = l1;
            } else {
                header = l1;
            }
        }
        if (l2 != null) {
            if (tmp != null) {
                tmp.next = l2;
            } else {
                header = l2;
            }
        }
        return header;
    }

    /**
     * 挨个合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode sorted = null;
        for (ListNode node: lists) {
            ListNode tmp = null, cur = sorted, header = null, next;
            while (cur != null && node != null) {
                if (cur.val <= node.val) {
                    next = cur.next;
                    if (tmp == null) {
                        header = cur;
                    } else {
                        tmp.next = cur;
                    }
                    tmp = cur;
                    cur = next;
                } else {
                    next = node.next;
                    if (tmp == null) {
                        header = node;
                    } else {
                        tmp.next = node;
                    }
                    tmp = node;
                    node = next;
                }
            }
            if (cur != null) {
                if (tmp != null) {
                    tmp.next = cur;
                } else {
                    header = cur;
                }
            }
            if (node != null) {
                if (tmp != null) {
                    tmp.next = node;
                } else {
                    header = node;
                }
            }
            sorted = header;
        }
        return sorted;
    }





    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                // l2 <= l1
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        if (l1 != null) {
            next.next = l1;
        } else {
            next.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ToolUtils.constructListNode(new int[]{1, 4, 5});
        ListNode[] params = new ListNode[3];
        params[0] = listNode1;
        ListNode listNode2 = ToolUtils.constructListNode(new int[]{1, 3, 4});
        params[1] = listNode2;
        ListNode listNode3 = ToolUtils.constructListNode(new int[]{2, 6});
        params[2] = listNode3;
        Merge_k_Sorted_Lists executor = new Merge_k_Sorted_Lists();
        ListNode result = executor.mergeKLists(params);
        ToolUtils.printListNode(result);
    }
}
