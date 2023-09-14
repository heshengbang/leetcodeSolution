package com.hsb.leetcode.medium;

public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] hasRead = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || hasRead[i][j]) {
                    continue;
                } else {
                    findWholeIsland(grid, i, j, hasRead);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void findWholeIsland(char[][] grid, int i, int j, boolean[][] hasRead) {
        hasRead[i][j] = true;
        // 左边
        if (j - 1 >= 0 && !hasRead[i][j - 1] && grid[i][j - 1] == '1') {
            findWholeIsland(grid, i, j - 1, hasRead);
        }
        // 正下方
        if (i + 1 < grid.length && !hasRead[i + 1][j]  && grid[i + 1][j] == '1') {
            findWholeIsland(grid, i + 1, j, hasRead);
        }
        // 右边
        if (j + 1 < grid[0].length && !hasRead[i][j + 1] && grid[i][j + 1] == '1') {
            findWholeIsland(grid, i, j + 1, hasRead);
        }
        // 正上方
        if (i - 1 >= 0 && !hasRead[i - 1][j] && grid[i - 1][j] == '1') {
            findWholeIsland(grid, i - 1, j, hasRead);
        }
    }
}
