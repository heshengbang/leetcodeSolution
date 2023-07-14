package com.hsb.leetcode.medium;

public class Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (tmp.length() == 0) {
                    if (!result.toString().endsWith(" ")) {
                        result.append(' ');
                    }
                } else {
                    result.append(tmp.reverse()).append(' ');
                    tmp = new StringBuilder();
                }
            } else {
                tmp.append(s.charAt(i));
            }
        }
        if (tmp.length() != 0) {
            result.append(tmp.reverse());
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
//        String s = "a good   example";
        String s = " String  ";
        Reverse_Words_in_a_String item = new Reverse_Words_in_a_String();
        System.out.println(item.reverseWords(s));
    }
}
