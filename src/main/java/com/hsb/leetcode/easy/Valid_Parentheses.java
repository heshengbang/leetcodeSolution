package com.hsb.leetcode.easy;

import java.util.LinkedList;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i =0; i < length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.addFirst(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (stack.peek() == null) {
                    return false;
                }
                char tmp = stack.poll();
                if (chars[i] == ')' && tmp == '(') {
                    continue;
                }
                if (chars[i] == '}' && tmp == '{') {
                    continue;
                }
                if (chars[i] == ']' && tmp == '[') {
                    continue;
                }
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Valid_Parentheses it = new Valid_Parentheses();
        System.out.println(it.isValid("()}"));
    }
}
