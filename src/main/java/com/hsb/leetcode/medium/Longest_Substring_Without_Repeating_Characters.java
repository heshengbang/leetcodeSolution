package com.hsb.leetcode.medium;

/**
 * @author heshengbang
 * 2019/5/16.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
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


    public int lengthOfLongestSubstring2(String s) {
        int[] table = new int[128];
        char[] chars = s.toCharArray();
        int left = 0, right = 0, length = s.length(), result = 0, count = 0;
        while (left <= right && right < length) {

            while (right < length && table[chars[right] - ' '] == 0) {
                count++;
                table[chars[right] - ' '] ++;
                right++;
            }

            result = Math.max(count, result);

            while (left <= right && right < length && table[chars[right] - ' '] > 0) {
                table[chars[left] - ' '] --;
                left++;
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters item = new Longest_Substring_Without_Repeating_Characters();
//        System.out.println(item.lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(item.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(item.lengthOfLongestSubstring2("pwwkew"));


    }
}
