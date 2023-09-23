package com.hsb.leetcode.had;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Nodes in k-Group
 *
 * [1,2,3,4,5]
 * 2
 */

public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        int[] param = {1, 2, 3, 4, 5};
        ListNode head = ToolUtils.constructListNode(param);
        Reverse_Nodes_in_k_Group item = new Reverse_Nodes_in_k_Group();
        head = item.reverseKGroup2(head, 3);
        ToolUtils.printListNode(head);
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null & count < k) {
            curr = curr.next;
            count++;
        }

        if(count == k) {
            curr = reverseKGroup3(curr, k);
            while(count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1 || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int index = 0;
        ListNode subHead = head;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            index++;
            if (index == k) {
                ListNode next = cur.next;
                cur.next = null;
                list.add(subHead);
                cur = next;
                subHead = cur;
                index = 0;
            } else {
                cur = cur.next;
            }
        }
        ListNode tail = null;
        if (subHead != null) {
            tail = subHead;
        }
        List<ListNode> reverseList = new ArrayList<>();
        for (ListNode it: list) {
            cur = it;
            subHead = cur;
            ListNode pre = null;
            while (true) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
                if (cur != null) {
                    subHead = cur;
                } else {
                    break;
                }
            }
            reverseList.add(subHead);
        }
        ListNode ans = null;
        for (ListNode it: reverseList) {
            if (ans == null) {
                ans = it;
            } else {
                cur.next = it;
            }
            cur = it;
            while (cur.next != null) {
                cur = cur.next;
            }
        }
        cur.next = tail;
        return ans;
    }



    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), pre = dummy, cur = pre;
        dummy.next = head;
        int num = 0;
        while ((cur = cur.next) != null) {
            ++num;
        }
        while (num >= k) {
            cur = pre.next;
            for (int i = 0; i < k; ++i) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            num -= k;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        int[] arr = toArray(head);
        int index = 0;
        while (index + k - 1 < arr.length) {
            reverseRangeOfArray(arr, index, index + k - 1);
            index += k;
        }
        return toListNode(arr);
    }

    private ListNode toListNode(int[] arr) {
        ListNode head = null;
        ListNode current = null;
        for (int item : arr) {
            if (current == null) {
                head = new ListNode(item);
                current = head;
            } else {
                ListNode next = new ListNode(item);
                current.next = next;
                current = next;
            }
        }
        return head;
    }

    private void reverseRangeOfArray(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }



}
