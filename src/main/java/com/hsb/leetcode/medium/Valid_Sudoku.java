package com.hsb.leetcode.medium;

import java.util.LinkedList;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] vertical = new boolean[9][9];
        boolean[][] horizontal = new boolean[9][9];
        boolean[][] small_cell = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                // 第i行中数字num有没有出现过
                if (horizontal[i][num]) {
                    return false;
                }
                if (vertical[j][num]) {
                    return false;
                }

                int h_mul = j / 3; // 3
                int v_mul = i / 3; // 3
                int num_cell = v_mul * 3 + h_mul;
                // 小格子中被使用的数字
                if (small_cell[num_cell][num]) {
                    return false;
                }

                horizontal[i][num] = true;
                vertical[j][num] = true;
                small_cell[num_cell][num] = true;
            }
        }
        return true;
    }
}
