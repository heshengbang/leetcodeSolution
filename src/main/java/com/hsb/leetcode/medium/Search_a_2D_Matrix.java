package com.hsb.leetcode.medium;

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] > target) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i - 1][j] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[m - 1][j] == target) {
                return true;
            }
        }
        return false;
    }
}
