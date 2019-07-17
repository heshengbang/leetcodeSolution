package com.hsb.leetcode.Medium;

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
    public String convert(String s, int numRows) {
        for (int row = 0;;row++) {
            for (int column = 0; column < numRows;column++) {
                if (row % 3 == 0) {

                } else {

                }
            }
        }
    }
}
