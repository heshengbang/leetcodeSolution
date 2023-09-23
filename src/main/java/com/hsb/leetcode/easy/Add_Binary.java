package com.hsb.leetcode.easy;

public class Add_Binary {
    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray();
        int aLength = a.length();
        char[] bchars = b.toCharArray();
        int bLength = b.length();

        char[] result = new char[aLength > bLength ? aLength:bLength];
        int index = result.length - 1;
        boolean jw = false;
        for (int i = aLength - 1, j = bLength - 1; i >= 0 || j >= 0;) {
            int sum = 0;
            if (i >= 0 && achars[i] == '1') {
                sum++;
            }
            if (j >= 0 && bchars[j] == '1') {
                sum++;
            }
            if (jw) {
                sum++;
                jw = false;
            }
            if (sum == 3) {
                result[index] = '1';
                jw = true;
            } else if (sum == 2) {
                result[index] = '0';
                jw = true;
            } else if (sum == 1) {
                result[index] = '1';
            } else {
                result[index] = '0';
            }
            index--;
            i--;
            j--;
        }
        String s = new String(result);
        if (jw) {
            return "1" + s;
        } else {
            return s;
        }
    }
}
