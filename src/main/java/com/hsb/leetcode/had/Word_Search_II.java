package com.hsb.leetcode.had;

import java.util.*;

public class Word_Search_II {
    public List<String> findWords(char[][] board, String[] words) {
        TrieTree root = buildTree(words);
        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieTree root, List<String> result) {
        char ch = board[i][j];
        // 不存在这个字符开头的字符串
        if (board[i][j] == '#' || root.next[ch - 'a'] == null) {
            return;
        }
        TrieTree next = root.next[ch - 'a'];
        // root.word 不为空，表明有一个字符串存在这里，从根节点到这里的字符依次组成了这个字符，而矩阵中的字符恰好能符合这个条件
        if (next.word != null) {
            result.add(next.word);
            // 避免再次搜索到这个字符，给结果集去重
            next.word = null;
        }
        // 避免重走
        board[i][j] = '#';
        if (i > 0) {
            // 向上搜索
            dfs(board, i - 1, j, next, result);
        }
        if (i < board.length - 1) {
            // 向下搜索
            dfs(board, i + 1, j, next, result);
        }
        if (j > 0) {
            // 向左搜索
            dfs(board, i, j - 1, next, result);
        }
        if (j < board[0].length - 1) {
            // 向右搜索
            dfs(board, i, j + 1, next, result);
        }
        // 方便其他搜索路径使用
        board[i][j] = ch;
    }

    /**
     * 构建一颗字典搜索树
     * @param words 源字符串数组
     * @return
     */
    private TrieTree buildTree(String[] words) {
        TrieTree root = new TrieTree();
        for (String word: words) {
            // 当前字符串的所有组成字符
            char[] chars = word.toCharArray();
            TrieTree p = root;
            for (char ch: chars) {
                int i = ch - 'a';
                // 这个字符在字典搜索树中当前这个层级是否存在
                if (p.next[i] == null) {
                    // 不存在就创建一个
                    p.next[i] = new TrieTree();
                }
                // 存在就进入这个已存在的子树
                p = p.next[i];
            }
            // 当前字符串的所有字符构建完毕，在这个结尾字符指向的next节点，把字符串的值放到这里，方便搜索最终结果
            p.word = word;
        }
        // 返回根节点
        return root;
    }

    /**
     * 字典搜索树
     * word表示从根节点到这里的所有字符组成的字符串
     * next表示从 a-z的所有字符串出现的可能
     */
    private class TrieTree {
        String word;
        TrieTree[] next = new TrieTree[26];
    }
}
