package com.hsb.leetcode.easy;


/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        int l1 = word1.length();
        char[] ch2 = word2.toCharArray();
        int l2 = word2.length();
        int length = word1.length() + word2.length();
        char[] merge = new char[length];
        int index = 0, i = 0, j = 0;
        while (index < length) {
            if (i < l1) {
                merge[index++] = ch1[i++];
            }
            if (j < l2) {
                merge[index++] = ch2[j++];
            }
        }
        return new String(merge);
    }

    public static void main(String[] args) {
//        String word1 = "abc", word2 = "pqr";

        String word1 = "ab", word2 = "pqrs";
        Merge_Strings_Alternately it = new Merge_Strings_Alternately();
        System.out.println(it.mergeAlternately(word1, word2));
    }
}
