package com.hsb.leetcode.easy;

/**
 * @author heshengbang
 * 2019/3/3.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/*

Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */

public class AddBinary {
    public static String addBinary(String a, String b) {
        char[] achas = reverse((a));
        char[] bchas = reverse(b);
        if (achas.length > bchas.length) {
            char[] temp = bchas;
            bchas = achas;
            achas = temp;
        }

        boolean carry = false;

        for (int i = 0; i < bchas.length; i++) {
            if (i >= achas.length) {
                if (carry && bchas[i] == '1') {
                    bchas[i] = '0';
                } else if (carry || bchas[i] == '1') {
                    bchas[i] = '1';
                    carry = false;
                }
                continue;
            }

            if (carry) {
                if (achas[i] == '1' && bchas[i] == '1') {
                    bchas[i] = '1';
                    carry = true;
                } else if (achas[i] == '1' || bchas[i] == '1') {
                    bchas[i] = '0';
                    carry = true;
                } else {
                    bchas[i] = '1';
                    carry = false;
                }
            } else {
                if (achas[i] == '1' && bchas[i] == '1') {
                    bchas[i] = '0';
                    carry = true;
                } else if (achas[i] == '1' || bchas[i] == '1') {
                    bchas[i] = '1';
                    carry = false;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if (carry) {
            result = new StringBuilder("1");
        }
        for (int i = bchas.length - 1; i >= 0; i--) {
            result.append(bchas[i]);
        }
        return result.toString();
    }

    private static char[] reverse(String str) {
        char[] chars = new char[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            chars[str.length() - 1 - i] = str.charAt(i);
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("101111", "10"));
    }
}
