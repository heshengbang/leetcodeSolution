package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @since 2020/2/6 16:51
 */

public class Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (judge(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean judge(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> relationShip = new HashMap<>();
        Map<Character, Character> reverse = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (relationShip.containsKey(pattern.charAt(i))) {
                if (!relationShip.get(pattern.charAt(i)).equals(word.charAt(i))) {
                    return false;
                }
            } else {
                relationShip.put(pattern.charAt(i), word.charAt(i));
            }
            if (reverse.containsKey(word.charAt(i))) {
                if (!reverse.get(word.charAt(i)).equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                reverse.put(word.charAt(i), pattern.charAt(i));
            }
        }
        return true;
    }

    private boolean judge1(String word, String pattern) {
        int[] sPattern = new int[26];
        int[] tPattern = new int[26];

        int currCount = 1;
        for(int i = 0; i < Math.min(word.length(), pattern.length()); i++)
        {
            if(sPattern[word.charAt(i) - 'a'] != tPattern[pattern.charAt(i) - 'a'])
            {
                return false;
            }
            sPattern[word.charAt(i) - 'a'] = currCount + 1;
            tPattern[pattern.charAt(i) - 'a'] = currCount + 1;
            currCount++;
        }
        return true;
    }

    public static void main(String[] args) {
        Find_and_Replace_Pattern item = new Find_and_Replace_Pattern();
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> result = item.findAndReplacePattern(words, pattern);
        System.out.println(result);
    }
}
