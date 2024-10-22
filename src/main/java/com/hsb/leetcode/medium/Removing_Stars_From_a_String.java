package com.hsb.leetcode.medium;

public class Removing_Stars_From_a_String {
    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        char[] removed = new char[s.length()];
        int index = -1;
        for (char ch: chars) {
            if ('*' == ch) {
                if (index > -1) {
                    index--;
                }
            } else {
                index++;
                removed[index] = ch;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= index; i++) {
            sb.append(removed[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "erase*****";
        Removing_Stars_From_a_String it = new Removing_Stars_From_a_String();
        System.out.println(it.removeStars(s));
    }
}
