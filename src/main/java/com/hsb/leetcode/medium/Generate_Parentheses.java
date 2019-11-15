package com.hsb.leetcode.medium;

/*
 * 类描述:
 * @since 2019/11/15 15:35
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        return construct("(", n - 1, n, 1);
    }

    private List<String> construct(String current, int left, int right, int count) {
        List<String> results = new ArrayList<>();
        if (left == 0 && right == 0) {
            results.add(current);
        } else if (left == 0) {
            results.addAll(construct(current + ")", 0, right - 1, count - 1));
        } else if (right == 0) {
            System.out.println("Shit, Something went wrong here!");
        } else {
            if (count > 0) {
                results.addAll(construct(current + "(", left - 1, right, count + 1));
                results.addAll(construct(current + ")", left, right - 1, count - 1));
            } else {
                results.addAll(construct(current + "(", left - 1, right, count + 1));
            }
        }
        return results;
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        char[] charArray = new char[n * 2];
        dfs(charArray, res, 0, 0, 0,n);
        return res;
    }

    private void dfs(char[] charArray, List<String> res, int left, int right, int index, int n) {
        if (right == n) {
            res.add(new String(charArray));
            return;
        }
        if (left < n) {
            charArray[index] = '(';
            dfs(charArray, res, left + 1, right, index + 1, n);
        }
        if (right < left) {
            charArray[index] = ')';
            dfs(charArray, res, left, right + 1, index + 1, n);
        }
    }

    public static void main(String[] args) {
        Generate_Parentheses item = new Generate_Parentheses();
        long start = System.currentTimeMillis();
        List<String> results = item.generateParenthesis1(14);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        for (String s: results) {
//            System.out.println(s);
        }

        start = System.currentTimeMillis();
        results = item.generateParenthesis(14);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        for (String s: results) {
//            System.out.println(s);
        }
    }
}
