package com.hsb.leetcode.had;

import java.util.Stack;

public class Basic_Calculator {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < length) {
            if (chars[index] == ' ') {
                index++;
                continue;
            }
            if (chars[index] == ')') {
                int num = 0, times = 1, sum = 0;
                while (stack.peek() != null && stack.peek() != '(') {
                    char tmp = stack.pop();
                    if (tmp == '-') {

                        // 发现负号以后，再找，能不能找到更多负号
                        boolean negative = true;
                        while (!stack.isEmpty() && stack.peek() == '-') {
                            negative = !negative;
                            stack.pop();
                        }
                        if (negative) {
                            sum = sum - num;
                        } else {
                            sum = sum + num;
                        }

                        times = 1;
                        num = 0;
                        continue;
                    }
                    if (tmp == '+') {
                        sum = sum + num;
                        times = 1;
                        num = 0;
                        continue;
                    }

                    num = num + (tmp - '0') * times;
                    times = times * 10;
                }
                if (num != 0) {
                    sum = sum + num;
                }
                stack.pop();
                char[] nc = String.valueOf(sum).toCharArray();
                for (char ch : nc) {
                    stack.push(ch);
                }
                index++;
                continue;
            }
            stack.push(chars[index]);
            index++;
        }

        int num = 0, times = 1, ans = 0;
        while (!stack.isEmpty()) {
            char tmp = stack.pop();
            if (tmp == '-') {
                // 发现负号以后，再找，能不能找到更多负号
                boolean negative = true;
                while (!stack.isEmpty() && stack.peek() == '-') {
                    negative = !negative;
                    stack.pop();
                }
                if (negative) {
                    ans = ans - num;
                } else {
                    ans = ans + num;
                }
                times = 1;
                num = 0;
                continue;
            }
            if (tmp == '+') {
                ans = ans + num;
                times = 1;
                num = 0;
                continue;
            }


            num = num + (tmp - '0') * times;
            times = times * 10;
        }
        if (num != 0) {
            ans = ans + num;
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "1 + 1";
//        String s = " 2-1 + 2 ";
//        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = "1-(     -2)";
        String s = "(1-(3-4))";
        Basic_Calculator it = new Basic_Calculator();
        System.out.println(it.calculate(s));
    }
}
