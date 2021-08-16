package com.hsb.leetcode.easy;


public class First_Unique_Character_in_a_String {

    public static int firstUniqChar(String s) {
        int[] chs = new int[26];
        int result = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chs[s.charAt(i) - 'a'] == 0) {
                result = i;
            }
            chs[s.charAt(i) - 'a']++;
        }
        if (chs[s.charAt(result) - 'a'] == 1) {
            return result;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }
}
