package com.hsb.leetcode.medium;

import java.util.*;

public class Clone_Graph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Integer, Node> hasCopied = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (hasCopied.containsKey(node.val)) {
            return hasCopied.get(node.val);
        }
        Node copy = new Node(node.val);
        hasCopied.put(node.val, copy);
        List<Node> neighbors = node.neighbors;
        if (neighbors == null || neighbors.isEmpty()) {
            return copy;
        }
        List<Node> copyNeighbors = new ArrayList<>();
        for (Node n1: neighbors) {
            if (hasCopied.containsKey(n1.val)) {
                copyNeighbors.add(hasCopied.get(n1.val));
            } else {
                copyNeighbors.add(cloneGraph(n1));
            }
        }
        copy.neighbors = copyNeighbors;
        return copy;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);

        Clone_Graph it = new Clone_Graph();

        Node copy = it.cloneGraph(n1);
        System.out.println(copy.val);

    }
}
