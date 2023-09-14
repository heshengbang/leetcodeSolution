package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] hasRead = new boolean[m][n];
            int i = 0, j = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(matrix[i][j]);
            hasRead[i][j] = true;
            while (true) {
                while (j + 1 < n && !hasRead[i][j + 1]) {
                    j++;
                    ans.add(matrix[i][j]);
                    hasRead[i][j] = true;
                }
                while (i + 1 < m && !hasRead[i + 1][j]) {
                    i++;
                    ans.add(matrix[i][j]);
                    hasRead[i][j] = true;
                }
                while (j - 1 >= 0 && !hasRead[i][j - 1]) {
                    j--;
                    ans.add(matrix[i][j]);
                    hasRead[i][j] = true;
                }
                while (i - 1 >= 0 && !hasRead[i - 1][j]) {
                    i--;
                    ans.add(matrix[i][j]);
                    hasRead[i][j] = true;
                }
                if ((j + 1 >= n || hasRead[i][j + 1])
                        && (i + 1 >= m || hasRead[i + 1][j])
                        && (j - 1 < 0 || hasRead[i][j - 1])
                        && (i - 1 < 0 || hasRead[i - 1][j])) {
                    break;
                }
            }
            return ans;
    }
}
