package com.hsb.leetcode.medium;

public class Set_Matrix_Zeroes {

    public void setZeroesInPlace(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        // 第一列，如果有0，这一整列都该为0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
            }
        }
        // 第一行，如果有0，这一整行都应该为0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 映射到第一列和第一行去，表明这一整行和整列都应该为0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
                // 如果第一行为0，那么整行都要设置为0
                if (i == 0 && firstRow) {
                    matrix[i][j] = 0;
                }
                // 如果第一列为0，那么整列都要为0
                if (j == 0 && firstColumn) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (firstColumn) {
                matrix[i][0] = 0;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (firstRow) {
                matrix[0][i] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowsHasSetZero = new boolean[m];
        boolean[] columnHasSetZero = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowsHasSetZero[i] = true;
                    columnHasSetZero[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (rowsHasSetZero[i]) {
                setWholeRowZero(matrix, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (columnHasSetZero[j]) {
                setWholeColumnZero(matrix, j);
            }
        }
    }

    private void setWholeColumnZero(int[][] matrix, int column_num) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column_num] = 0;
        }
    }

    private void setWholeRowZero(int[][] matrix, int row_num) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row_num][i] = 0;
        }
    }
}
