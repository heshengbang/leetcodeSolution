package com.hsb.leetcode.had;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路参考N_Queens_II
 * 判断每一行皇后可能摆放的位置，判断其和之前摆放的皇后是否存在行/列/斜对角冲突，然后进行深度优先搜索判断
 */

public class N_Queens {

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        //chars[i][j]代表位置(i,j)是皇后还是空位
        char[][] chars = new char[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        process(0, chars, n, result);
        return result;
    }

    public void process(int i, char[][] chars, int n, ArrayList<List<String>> result) {
        if (i >= n) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(j, new String(chars[j]));
            }
            result.add(temp);
        } else {
            for (int j = 0; j < n; j++) {
                if (isValid(chars, i, j)) {
                    chars[i][j] = 'Q';
                    process(i + 1, chars, n, result);
                }
                chars[i][j] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int i, int j) {
        //检查列
        for (int k = 0; k < i; k++) {
            if (chars[k][j] == 'Q') {
                return false;
            }
        }
        int m = i, n = j;
        //检查反斜线
        while (--m >= 0 && --n >= 0) {
            if (chars[m][n] == 'Q') {
                return false;
            }
        }
        //检查斜线
        while (--i >= 0 && ++j < chars.length) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
