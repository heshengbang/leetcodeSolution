package com.hsb.leetcode.medium;

public class LRUCache {
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int count;
    private ListNode[] mem;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        count = 0;
        mem = new ListNode[10001];
    }

    public int get(int key) {
        if (mem[key] == null) {
            return -1;
        }
        ListNode node = mem[key];
        deleteNode(node);
        moveToHead(node);
        return node.value;
    }

    private void deleteNode(ListNode node) {
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void put(int key, int value) {
        if (mem[key] != null) {
            ListNode node = mem[key];
            node.value = value;
            deleteNode(node);
            moveToHead(node);
            return;
        }
        if (count == capacity) {
            deleteLeastRecentlyUsedNode();
            count--;
        }
        ListNode node = new ListNode(key, value);
        mem[key] = node;
        moveToHead(node);
        count++;
    }

    private void deleteLeastRecentlyUsedNode() {
        ListNode lastNode = tail.pre;
        if (lastNode == head) {
            return;
        }
        lastNode.pre.next = tail;
        tail.pre = lastNode.pre;
        mem[lastNode.key] = null;
    }

    private void moveToHead(ListNode node) {
        ListNode firstNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = firstNode;
        firstNode.pre = node;
    }

    private class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode pre;

        public ListNode() {

        }
        public ListNode (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }
//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(1);
//        lruCache.put(2, 1);
//        System.out.println(lruCache.get(2));
//        lruCache.put(3, 2);
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
//
//    }

}
