package com.hsb.leetcode.medium;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node copied = null;
        Node copiedHead = null;
        while (cur != null) {
            if (copied == null) {
                copied = new Node(cur.val);
                copiedHead = copied;
            } else {
                copied.next = new Node(cur.val);
                copied = copied.next;
            }
            cur = cur.next;
        }
        cur = head;
        copied = copiedHead;
        while (cur != null) {
            Node random = cur.random;
            if (random != null) {
                Node search = head;
                Node copiedSearch = copiedHead;
                while (search != null && search != random) {
                    search = search.next;
                    copiedSearch = copiedSearch.next;
                }
                copied.random = copiedSearch;
            }
            cur = cur.next;
            copied = copied.next;
        }
        return copiedHead;
    }


    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
