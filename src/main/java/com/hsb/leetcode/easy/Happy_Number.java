package com.hsb.leetcode.easy;

/*
 * @since 2019/12/3 21:12
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 */
public class Happy_Number {

    public boolean isHappy1(int n) {
        Map<Integer, Object> map = new HashMap<>();
        map.put(n, null);
        int sum = n;
        while(true) {
            char[] chars = String.valueOf(sum).toCharArray();
            sum = 0;
            for(int i = 0; i < chars.length;i++) {
                sum = sum + (chars[i] - '0')*(chars[i] - '0');
            }
            if (sum == 1) {
                return true;
            }
            if (map.containsKey(sum)) {
                return false;
            } else {
                map.put(sum, null);
            }
        }
    }


    public boolean isHappy(int n) {
        Set<Integer> path = new HashSet<>();
        return  cycleCalculate(n, path);
    }

    private boolean cycleCalculate(int n, Set<Integer> path) {
        if (path.contains(n)) {
            return false;
        } else {
            path.add(n);
        }
        int results = 0;
        while (n > 0) {
            results += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (results == 1) {
            return true;
        } else {
            return cycleCalculate(results, path);
        }
    }

    public static void main(String[] args) {
//        Happy_Number it = new Happy_Number();
//        System.out.println(it.isHappy(5));

    }
}
