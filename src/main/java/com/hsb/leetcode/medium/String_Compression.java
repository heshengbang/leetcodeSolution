package com.hsb.leetcode.medium;

public class String_Compression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0, index = 0;
        while (true) {
            if (count == 0) {
                count++;
                index++;
            } else {
                if (index == chars.length || chars[index] != chars[index - 1]) {
                    sb.append(chars[index - 1]);
                    if (count != 1) {
                        sb.append(count);
                    }
                    count = 0;
                    if (index == chars.length) {
                        break;
                    }
                } else {
                    count++;
                    index++;
                }
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
       char[] chars = {'a','a','b','b','c','c','c'};
        String_Compression item = new String_Compression();
        System.out.println(item.compress(chars));
    }
}
