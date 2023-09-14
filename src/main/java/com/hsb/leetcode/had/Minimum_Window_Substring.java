package com.hsb.leetcode.had;

import java.util.Arrays;
import java.util.Map;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        int lengthOfMem = 'z' - 'A';
        int[] mem = new int[lengthOfMem + 1];
        char[] chT = t.toCharArray();
        char[] chS = s.toCharArray();
        for (char ch: chT) {
            mem[ch - 'A']++;
        }
        int left = 0, right = 0;
        int ansLeft = 0, minLength = Integer.MAX_VALUE;
        while (right < lengthS) {
            char ch_Right = chS[right];
            if (mem[ch_Right - 'A'] > 0) {
                lengthT--;
            }
            mem[ch_Right - 'A']--;
            while (lengthT == 0) {
                int curLength = right - left + 1;
                if (curLength < minLength) {
                    minLength = curLength;
                    ansLeft = left;
                }
                char ch_left = chS[left];
                if (mem[ch_left - 'A'] == 0) {
                    lengthT++;
                }
                mem[ch_left - 'A']++;
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : new String(chS, ansLeft, minLength);
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk";
        String t = "mqfff";
        Minimum_Window_Substring it = new Minimum_Window_Substring();
        System.out.println(it.minWindow(s, t));
    }
}
