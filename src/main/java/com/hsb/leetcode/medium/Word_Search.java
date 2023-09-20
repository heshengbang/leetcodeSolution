package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Word_Search {
    public boolean exist1(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int wordLength = word.length();
        List<int[]> list = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        if (m * n < wordLength) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到所有第一个字符所在的位置
                if (board[i][j] == chars[0]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int wordIndex = 0;
        int[][] mem = new int[wordLength][2];
        for (int[] it: list) {
            if (backTracking(board, it, chars, mem, wordIndex)) {
                return true;
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, int[] it, char[] chars, int[][] mem, int wordIndex) {
        int i = it[0];
        int j = it[1];
        if (wordIndex == chars.length) {
            return true;
        }
        if (i < 0 || j < 0) {
            return false;
        }
        if (i >= board.length || j >= board[0].length) {
            return false;
        }
        // 判断是否走过
        for (int x = 0; x < wordIndex; x++) {
            // 走过的路不再走
            if (mem[x][0] == i && mem[x][1] == j) {
                return false;
            }
        }

        if (board[i][j] != chars[wordIndex]) {
            return false;
        }
        mem[wordIndex] = it;
        // 向上搜索
        boolean up = backTracking(board, new int[]{i - 1, j}, chars, mem, wordIndex + 1);
        if (up) {
            return true;
        }
        // 向下搜索
        boolean bottom = backTracking(board, new int[]{i + 1, j}, chars, mem, wordIndex + 1);
        if (bottom) {
            return true;
        }
        // 向右搜索
        boolean right = backTracking(board, new int[]{i, j + 1}, chars, mem, wordIndex + 1);
        if (right) {
            return true;
        }
        // 向左搜索
        boolean left = backTracking(board, new int[]{i, j - 1}, chars, mem, wordIndex + 1);
        if (left) {
            return true;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int wordLength = word.length();
        List<int[]> list = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        if (m * n < wordLength) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到第一个字符所在的位置
                if (board[i][j] == chars[0]) {
                    // 第一个是纵轴坐标，第二个是横坐标，第三个是来的方向，0表示原点，1表示上，2表示下，3表示左，4表示右
                    list.add(new int[]{i, j, 0});
                }
            }
        }
        for (int x = 1; x < wordLength; x++) {
            List<int[]> tmp = new ArrayList<>();
            for (int[] it: list) {
                int i = it[0];
                int j = it[1];
                // 来自的节点，不去判断那个方向
                int direct = it[2];
                if (direct != 1) {
                    if (i - 1 >= 0 && board[i - 1][j] == chars[x]) {
                        tmp.add(new int[]{i - 1, j, 2});
                    }
                }
                if (direct != 2) {
                    if (i + 1 < m && board[i + 1][j] == chars[x]) {
                        tmp.add(new int[]{i + 1, j, 1});
                    }
                }
                if (direct != 3) {
                    if (j - 1 >= 0 && board[i][j - 1] == chars[x]) {
                        tmp.add(new int[]{i, j - 1, 4});
                    }
                }
                if (direct != 4) {
                    if (j + 1 < n && board[i][j + 1] == chars[x]) {
                        tmp.add(new int[]{i, j + 1, 3});
                    }
                }
            }
            if (tmp.size() == 0) {
                list = tmp;
                break;
            }
            list = tmp;
        }
        return list.size() > 0;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCB";

        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";

        Word_Search it = new Word_Search();
        System.out.println(it.exist(board, word));
    }
}
