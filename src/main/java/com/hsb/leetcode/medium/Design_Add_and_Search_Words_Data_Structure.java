package com.hsb.leetcode.medium;

import java.util.*;

public class Design_Add_and_Search_Words_Data_Structure {
    private TrieNode head;

    public Design_Add_and_Search_Words_Data_Structure() {
        this.head = new TrieNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = this.head;
        for (char ch: chars) {
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new TrieNode();
            }
            cur = cur.next[ch - 'a'];
        }
        cur.word = word;
    }

    public boolean search(String word) {
        return match(Collections.singletonList(head), word);
    }

    private boolean match(List<TrieNode> nodes, String word) {
        if (word.length() == 0) {
            for (TrieNode node: nodes) {
                if (node.word != null) {
                    return true;
                }
            }
            return false;
        }
        char ch = word.charAt(0);
        List<TrieNode> list = new ArrayList<>();
        for (TrieNode node: nodes) {
            if (ch == '.') {
                for (TrieNode it: node.next) {
                    if (it != null) {
                        list.add(it);
                    }
                }
                continue;
            }
            if (node.next[ch - 'a'] != null) {
                list.add(node.next[ch - 'a']);
            }
        }
        return match(list, word.substring(1));
    }

    private class TrieNode {
        TrieNode[] next;
        String word;
        public TrieNode() {
            next = new TrieNode[26];
        }
    }


    public static void main(String[] args) {
        Design_Add_and_Search_Words_Data_Structure wordDictionary= new Design_Add_and_Search_Words_Data_Structure();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.out.println(wordDictionary.search("m.da")); // return false

        // ["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
        // [[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]
//        wordDictionary.addWord("a");
//        wordDictionary.addWord("ab");
//        System.out.println(wordDictionary.search("a")); // true,
//        System.out.println(wordDictionary.search("a.")); // true,
//        System.out.println(wordDictionary.search("ab"));// true,
//        System.out.println(wordDictionary.search(".a"));// false
//        System.out.println(wordDictionary.search(".b"));// ,true,
//        System.out.println(wordDictionary.search("ab.")); // false,
//        System.out.println(wordDictionary.search("."));// true
//        System.out.println(wordDictionary.search(".."));//true
    }
}
