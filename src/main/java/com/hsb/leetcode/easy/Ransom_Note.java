package com.hsb.leetcode.easy;

/**
 *
 * Ransom Note
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        int[] letterList = new int[26];
        for (int i = 0; i < chars2.length; i++) {
            letterList[chars2[i] - 'a']++;
        }

        for (int i = 0; i < chars1.length; i++) {
            int letter = chars1[i] - 'a';
            if (letterList[letter] < 1) {
                return false;
            } else {
                letterList[letter]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String ransomNote = "a";
//        String magazine = "b";

//        String ransomNote = "aa";
//        String magazine = "ab";

        String ransomNote = "aa";
        String magazine = "aab";

        Ransom_Note item = new Ransom_Note();
        System.out.println(item.canConstruct(ransomNote, magazine));
    }
}
