package com.hsb.leetcode.medium;

public class Game_of_Life {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nums = getAliveNeighbors(board, i, j, m, n);
                if (nums < 2) {
                    // 活得变成死的，死的还是死的
                    copy[i][j] = 0;
                } else if (nums == 2) {
                    // 活的还是活的，死的还是死的
                    copy[i][j] = board[i][j];
                } else if (nums == 3) {
                    // 死的变成活的，活的还是活的
                    copy[i][j] = 1;
                } else {
                    // 活的变成死的，死的还是死的
                    copy[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = copy[i][j];
            }
        }
    }

    private int getAliveNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (i - 1 >= 0) {
            if (j - 1 >= 0) {
                // 左上角
                if (board[i - 1][j - 1] == 1) {
                    count++;
                }
            }
            // 正上方
            if (board[i - 1][j] == 1) {
                count++;
            }
            if (j + 1 < n) {
                // 右上角
                if (board[i - 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        if (j - 1 >= 0) {
            // 左边
            if (board[i][j - 1] == 1) {
                count++;
            }
        }
        if (j + 1 < n) {
            // 右边
            if (board[i][j + 1] == 1) {
                count++;
            }
        }
        if (i + 1 < m) {
            if (j - 1 >= 0) {
                // 左下角
                if (board[i + 1][j - 1] == 1) {
                    count++;
                }
            }
            // 正下方
            if (board[i + 1][j] == 1) {
                count++;
            }
            if (j + 1 < n) {
                // 右下角
                if (board[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
