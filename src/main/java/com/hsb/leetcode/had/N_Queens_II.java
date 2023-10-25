package com.hsb.leetcode.had;

public class N_Queens_II {
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        //record[i]记录了第i行皇后所在的列号
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * 判定第index行其摆放皇后的不同方式
     *   当前行摆放合法只是条件之一，后续行都可以摆放成功才可以，如果某一行无法合法摆放，此前的摆放结果就不可用，因此res将是0
     *   所以结果是当前行和后续行都可以摆放同时满足的结果
     *   第n行是不存在的，作为递归终止条件，给出1是表明从index ~ n - 1都满足的情况下，这是一种摆法，最终res也将只是1
     *
     *   这也是一种深度优先搜索算法
     *
     * @param index 尝试第index行的皇后摆法
     * @param record record[index]记录了第index行皇后所在的列号
     * @param n 矩形的边长，皇后的个数
     * @return 皇后在矩阵中的不同摆法
     */
    public int process(int index, int[] record, int n) {
        // 第n行
        if (index == n) {
            return 1;
        }
        int res = 0;
        // 在第index行，从0 到 n - 1开始
        for (int j = 0; j < n; j++) {
            // 判定在第index行第j列，摆放一个皇后，这种摆放方式是否可行
            if (isValid(record, index, j)) {
                // 这种摆法没问题，则在record中记录index行，其所在列的位置
                record[index] = j;
                // 递归判定当前行的下一行摆放的不同方式，作为子问题的解，添加到当前解法的答案上
                res += process(index + 1, record, n);
            }
        }
        // 返回不同的解法
        return res;
    }

    /**
     * 判定在第index行第j列，摆放一个皇后，这种摆放方式是否可行
     *  判定合法的方式是所在行不能相同，所在列也不能相同，斜对角也不能相同
     *  因为record是从小到大赋值，所以record有值的记录仅存在于0 ~ i - 1，所以行不用判断
     *  record[k] == j判断所在列是否冲突
     *  Math.abs(record[k] - j) == Math.abs(k - i) 判断斜对角是否冲突
     *
     * @param record 记录每一行的皇后摆放的位置
     * @param i 当前新增皇后所在的行数
     * @param j 当前新增皇后所在的列数
     * @return 是否和record中已存在的皇后存在冲突
     */
    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N_Queens_II it = new N_Queens_II();
        for (int i = 1; i < 10; i++) {
            System.out.println("在" + i + "X" + i + "的棋盘格子中摆放" + i + "个皇后的不同摆法有：" + it.totalNQueens(i));
        }
    }
}
