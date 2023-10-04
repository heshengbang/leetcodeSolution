package com.hsb.leetcode.medium;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {

            if ("+".equals(token)) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i1 + i2);
                continue;
            }
            if ("-".equals(token)) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 - i1);
                continue;
            }
            if ("*".equals(token)) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 * i1);
                continue;
            }
            if ("/".equals(token)) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 / i1);
                continue;
            }

            stack.push(Integer.valueOf(token));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};

        Evaluate_Reverse_Polish_Notation it = new Evaluate_Reverse_Polish_Notation();
        System.out.println(it.evalRPN(tokens));
    }
}
