package com.hsb.leetcode.medium;

public class Implement_Trie_Prefix_Tree {
    Implement_Trie_Prefix_Tree[] next = new Implement_Trie_Prefix_Tree[26];
    String word;

    public Implement_Trie_Prefix_Tree() {

    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        // 以当前树为根节点，构建字典搜索树
        Implement_Trie_Prefix_Tree p = this;
        for (char ch: chars) {
            // 索引
            int index = ch - 'a';
            // 代表对应的字符，如果这个字符之前没被插入过，则创建一个新的
            if (p.next[index] == null) {
                p.next[index] = new Implement_Trie_Prefix_Tree();
            }
            // 继续添加新的字符索引
            p = p.next[index];
        }
        // 最后一个字符创建的空节点的word指向被插入的word，这样可以方便搜索
        p.word = word;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        // 以当前树为根节点，构建字典搜索树
        Implement_Trie_Prefix_Tree p = this;
        for (char ch: chars) {
            // 索引
            int index = ch - 'a';
            // 代表对应的字符，如果这个字符之前没被插入过，则搜索结束，返回false
            if (p.next[index] == null) {
                return false;
            }
            // 继续搜索子树
            p = p.next[index];
        }
        // 最后一个字符创建的空节点的word是否等于word
        return word.equals(p.word);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        // 以当前树为根节点，构建字典搜索树
        Implement_Trie_Prefix_Tree p = this;
        for (char ch: chars) {
            // 索引
            int index = ch - 'a';
            // 代表对应的字符，如果这个字符之前没被插入过，则搜索结束，返回false
            if (p.next[index] == null) {
                return false;
            }
            // 继续搜索子树
            p = p.next[index];
        }
        // 代表字符串的搜索路径可以被找到，存在一个以这个为前缀的字符串
        return true;
    }
}
