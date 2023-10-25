package com.hsb.leetcode.medium;

public class Construct_Quad_Tree {
    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return buildNode(grid, 0, 0, n);
    }

    Node buildNode(int[][] grid, int r, int c, int len) {
        if (allSame(grid, r, c, len))
            return new Node(grid[r][c] == 1 ? true : false, true);

        Node root = new Node(true, false);
        // 矩阵起点的(r,c)和边长
        root.topLeft = buildNode(grid, r, c, len / 2);
        root.topRight = buildNode(grid, r, c + len / 2, len / 2);
        root.bottomLeft = buildNode(grid, r + len / 2, c, len / 2);
        root.bottomRight = buildNode(grid, r + len / 2, c + len / 2, len / 2);
        return root;
    }

    boolean allSame(int[][] grid, int r, int c, int len) {
        int cur = grid[r][c];
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (grid[i][j] != cur) return false;
            }
        }
        return true;
    }
}
