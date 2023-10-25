package com.hsb.leetcode.medium;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Populating_Next_Right_Pointers_in_Each_Node_II {


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> curLevel = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        curLevel.add(root);
        Node pre = null;
        while (!curLevel.isEmpty()) {
            Node tmp = curLevel.pop();
            if (pre != null) {
                pre.next = tmp;
            }
            pre = tmp;
            if (tmp.left != null) {
                nextLevel.add(tmp.left);
            }
            if (tmp.right != null) {
                nextLevel.add(tmp.right);
            }
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
                pre = null;
            }
        }
        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
