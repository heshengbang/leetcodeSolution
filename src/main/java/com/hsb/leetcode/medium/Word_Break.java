package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word_Break {
    /**
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     *
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     *
     *
     * 初始状态，字符串s为空的时候，如果字符串字典中包含空字符串，则为true，否则为false
     * 状态参数选用s的字符位置，从0 ~ s.length遍历整个子字符串的所有可能
     *  判断s.subString(0, i)是否可以被拆分为多个字符串，这些字符串需要在字符串字典中
     *  如果s.subString(0, j)是字符串字典中的字符串，那么只需要判断s.subString(j, i)即可
     *  所以s.subString(0, i)的子问题就是s.subString(0, j)和s.subString(j, i)，前者问题已经计算过了，后者是可以计算
     *
     * 状态存储备忘录可以选择dp[n]，dp[i]表示0 ~ i的s的子字符串是否可以被拆分为多个子字符串，这些字符串都在字符串字典中
     *
     * 状态转移方程即dp[i] = （s.subString(0, i) ∈ wordDict） or (s.subString(j, i) ∈ wordDict, 0 < j < i, s.subString(0, j)=true)
     *
     * @param s 给定的字符串
     * @param wordDict 字符串字典
     * @return true of false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        // 初始状态，判断空字符串是否是字符串字典中的元素
        dp[0] = wordDict.indexOf("") > -1;

        // 此处索引从1开始，因为subString是包含左边不包含右边
        // dp[0]是指一个空字符串，dp[1]是指s的第一个字符构成的字符串，这里的索引需要调整
        for (int i = 1; i < length + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    // 如果dp[j]为true，则证明从之前s的某个位置到j可以组成一个在字符串字典中的字符串，那么从j 到 i，可能就没有被判断过
                    String tmp = s.substring(j, i);
                    // 如果tmp在字符字典中，就赋值true，否则false
                    dp[i] = wordDict.indexOf(tmp) > -1;
                    if (dp[i]) {
                        // 找到了dp[i]=true的情况就跳出当前循环
                        break;
                    }
                }
            }
            if (!dp[i]) {
                // 如果始终没找到i之前为true的情况或者找到了，但是没有构成一个合适的字符串，则判断 0 ~ i是否为一个在字符串字典中的字符串
                String tmp = s.substring(0, i);
                dp[i] = wordDict.indexOf(tmp) > -1;
            }
        }
        // 返回由s构成的字符串
        return dp[length];
    }

    public static void main(String[] args) {
        Word_Break it = new Word_Break();
//        String s = "leetcode";
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
        wordDict.add("aaaa");
        wordDict.add("aaa");

        System.out.println(it.wordBreak(s, wordDict));
    }
}
