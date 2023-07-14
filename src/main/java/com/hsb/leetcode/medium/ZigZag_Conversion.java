package com.hsb.leetcode.medium;

/*
 * 类描述:
 * Copyright trulyheshengbang@gmail.com
 * @since 2019/7/17 16:45
 * @version 1.0
 * @author heshengbang
 *************************************************
 */


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZag_Conversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        char[][] arrays = new char[numRows][s.length()];
        int stringIndex = 0;
        int mode = numRows - 1;
        first:
        for (int column = 0;;column++) {
            for (int row = 0; row < numRows;row++) {
                if (stringIndex >= s.length()) {
                    break first;
                }
                if (column % mode == 0) {
                    arrays[row][column] = s.charAt(stringIndex);
                    stringIndex++;
                } else {
                    int rest = column % mode;
                    arrays[mode - rest][column] = s.charAt(stringIndex);
                    stringIndex++;
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows;i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arrays[i][j]!='\u0000') {
                    stringBuilder.append(arrays[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int[] nums = new int[s.length()];
        int row = 0;
        boolean increase = true;
        for (int i = 0; i < s.length(); i++) {
            nums[i] = row;
            if (row + 1 >= numRows) {
                increase = false;
            }
            if (row - 1 < 0) {
                increase = true;
            }
            if (increase) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder[] all = new StringBuilder[numRows];
        for (int i = 0; i < s.length(); i++) {
            if (all[nums[i]] == null) {
                all[nums[i]] = new StringBuilder();
            }
            all[nums[i]].append(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: all) {
            if (sb == null || sb.length() == 0) {
                continue;
            }
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 4));

        ZigZag_Conversion item = new ZigZag_Conversion();
//        System.out.println(item.convert1("A", 2));
//        System.out.println(item.convert1("AB", 1));
    }
}
