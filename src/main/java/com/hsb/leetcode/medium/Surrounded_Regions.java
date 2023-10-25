package com.hsb.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Surrounded_Regions {
    private boolean[][] visited;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        // 从最上方边界向下搜索
        for (int i = 0; i < n; i++) {
            dfs(0, i, board, m, n);
        }
        // 从最右边边界向左搜索
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, board, m, n);
        }
        // 从最下方边界向上开始搜索
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, board, m, n);
        }
        // 从最左边边界向右搜索
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果为O但是未被访问过，表明未和边界搭边，所以可以被置为X
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, int m, int n) {
        if (board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        // 向上搜索
        if (i > 0) {
            dfs(i - 1, j, board, m, n);
        }
        // 向下搜索
        if (i + 1 < m) {
            dfs(i + 1, j, board, m, n);
        }
        // 向左搜索
        if (j > 0) {
            dfs(i, j - 1, board, m, n);
        }
        // 向右搜索
        if (j + 1 < n) {
            dfs(i, j + 1, board, m, n);
        }
    }
}
