package com.hsb.leetcode.medium;

/**
 * @version 1.0
 * @since 2020/2/7 15:38
 */

public class Custom_Sort_String {
    public String customSortString(String S, String T) {
        String[] array = new String[26];
        for (char ch : T.toCharArray()) {
            if (array[ch - 'a'] == null) {
                array[ch - 'a'] = String.valueOf(ch);
            } else {
                array[ch - 'a'] += ch;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch: S.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' && array[ch - 'a'] != null) {
                result.append(array[ch - 'a']);
                array[ch - 'a'] = "";
            }
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != null && !"".equals(array[i])) {
                result.append(array[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Custom_Sort_String item = new Custom_Sort_String();
        System.out.println(item.customSortString("cbafg",
                "abcd"));
    }
}
