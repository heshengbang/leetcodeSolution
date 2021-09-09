package com.hsb.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboard_Row {
    public String[] findWords(String[] words) {
        String rowOne = "qwertyuiop";
        String rowTwo = "asdfghjkl";
        String rowThree = "zxcvbnm";
        int[] original = new int[26];
        for (int i = 0; i < 26; i++) {
            if (rowOne.contains(String.valueOf((char)('a' + i)))) {
                original[i] = 1;
            } else if (rowTwo.contains(String.valueOf((char)('a' + i)))) {
                original[i] = 2;
            } else if (rowThree.contains(String.valueOf((char)('a' + i)))) {
                original[i] = 3;
            } else {
                original[i] = 4;
            }
        }
        List<String> list = new ArrayList<>();
        for (String item: words) {
            if (sameRow(item.toLowerCase(), original)) {
                list.add(item);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean sameRow(String item, int[] original) {
        int row = 0;
        for (char ch: item.toCharArray()) {
            if (row == 0) {
                row = original[ch - 'a'];
            } else {
                if (original[ch - 'a'] != row) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array = {"Hello","Alaska","Dad","Peace"};
        Keyboard_Row item = new Keyboard_Row();
        System.out.println(Arrays.toString(item.findWords(array)));
    }
}
