package com.hsb.leetcode.had;

import java.util.*;

/**
 *
 * Substring with Concatenation of All Words
 *
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 *
 */
public class Substring_with_Concatenation_of_All_Words {


    public List<Integer> findSubstring4(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] s2 = s.toCharArray();
        for (String value : words) {
            hash.putIfAbsent(value, hash.size());
        }
        int[] count = new int[hash.size()];
        for (String word : words) {
            count[hash.get(word)]++;
        }
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalWordsLength; j += wordLength) {
                int[] localCount = new int[hash.size()];
                for (int k = j + totalWordsLength - wordLength; k >= j; k -= wordLength) {
                    String str = new String(s2, k, wordLength);     // [ k, k+wordLength )
                    Integer key = hash.get(str);
                    if (!(key != null && count[key] >= ++localCount[key])) {
                        j = k;
                        break;
                    }
                    if (j == k) {
                        ans.add(j);
                    }
                }
            }
        }
        return ans;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        int allWordsLength = 0;
        for (String it: words) {
            allWordsLength += it.length();
        }
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i + allWordsLength <= length; i++) {
            if (findWords(s.substring(i, i + allWordsLength), words)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean findWords(String substring, String[] words) {
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        int length = wordsList.get(0).length();
        while (substring.length() > 0 && wordsList.size() > 0) {
            String tmp = substring.substring(0, length);
            if (wordsList.remove(tmp)) {
                substring = substring.substring(length);
            } else {
                return false;
            }
        }
        return wordsList.size() == 0;
    }


    public List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String it: words) {
            if (wordsMap.containsKey(it)) {
                wordsMap.put(it, wordsMap.get(it) + 1);
            } else {
                wordsMap.put(it, 1);
            }
        }
        int allWordsLength = 0;
        for (String it: words) {
            allWordsLength += it.length();
        }
        int length = s.length(), singleWordLength = words[0].length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i + allWordsLength <= length; i++) {
            Map<String, Integer> clone = new HashMap<>(wordsMap);
            if (findWords2(s.substring(i, i + allWordsLength), singleWordLength, clone)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean findWords2(String substring, int length, Map<String, Integer> wordsMap) {
        while (substring.length() > 0 && !wordsMap.isEmpty()) {
            String tmp = substring.substring(0, length);
            if (wordsMap.containsKey(tmp)) {
                int count = wordsMap.get(tmp) - 1;
                if (count == 0) {
                    wordsMap.remove(tmp);
                } else {
                    wordsMap.put(tmp, count);
                }
                substring = substring.substring(length);
            } else {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findSubstring3(String s, String[] words) {
        return new AbstractList<Integer>() {
            List<Integer> result;


            @Override
            public Integer get(int index) {
                if (result == null) {
                    init();
                }
                return result.get(index);
            }

            private void init() {
                result = new ArrayList<>();
                Map<String, Integer> wordsMap = new HashMap<>();
                for (String it: words) {
                    if (wordsMap.containsKey(it)) {
                        wordsMap.put(it, wordsMap.get(it) + 1);
                    } else {
                        wordsMap.put(it, 1);
                    }
                }
                int allWordsLength = 0;
                for (String it: words) {
                    allWordsLength += it.length();
                }
                int length = s.length(), singleWordLength = words[0].length();
                for (int i = 0; i + allWordsLength <= length; i++) {
                    Map<String, Integer> clone = new HashMap<>(wordsMap);
                    String substring = s.substring(i, i + allWordsLength);
                    while (substring.length() > 0 && !clone.isEmpty()) {
                        String tmp = substring.substring(0, singleWordLength);
                        if (clone.containsKey(tmp)) {
                            int count = clone.get(tmp) - 1;
                            if (count == 0) {
                                clone.remove(tmp);
                            } else {
                                clone.put(tmp, count);
                            }
                            substring = substring.substring(singleWordLength);
                        } else {
                            break;
                        }
                    }
                    if (substring.length() == 0 && clone.isEmpty()) {
                        result.add(i);
                    }
                }
            }

            @Override
            public int size() {
                if (result == null) {
                    init();
                }
                return result.size();
            }
        };
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","word"};

//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar","foo","the"};

//        String s = "aaaaaaaaaaaaaa";
//        String[] words = {"aa","aa"};

//        String s = "ababaab";
//        String[] words = {"ab","ba","ba"};


        Substring_with_Concatenation_of_All_Words it = new Substring_with_Concatenation_of_All_Words();
        List<Integer> list = it.findSubstring4(s, words);
        for (Integer item: list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
