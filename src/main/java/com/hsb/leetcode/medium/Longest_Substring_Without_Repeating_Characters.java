package com.hsb.leetcode.medium;

/**
 * @author heshengbang
 * 2019/5/16.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        if (s.length() <= 1) {
            return s.length();
        }

        for (int i = 0; i < s.length(); i++) {
            String string = s.substring(i);
            int maxlength = 0;
            for (int j = 1; j < string.length();j++) {
                if (string.substring(0, j).indexOf(string.charAt(j)) >= 0) {
                    maxlength = j;
                    break;
                }
                maxlength = j + 1;
            }
            result = (result < maxlength ? maxlength : result);
        }
        return result;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters item = new Longest_Substring_Without_Repeating_Characters();
        System.out.println(item.lengthOfLongestSubstring("bbbbb"));
    }
}
