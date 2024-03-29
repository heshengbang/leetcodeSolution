package com.hsb.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/1 14:00
 *
 * @author heshengbang
 */

/*
Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II.
The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

https://leetcode.com/problems/roman-to-integer

 */

public class Roman_to_Integer {
    private static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> code = new TreeMap<Character, Integer>();
        code.put('I', 1);
        code.put('V', 5);
        code.put('X', 10);
        code.put('L', 50);
        code.put('C', 100);
        code.put('D', 500);
        code.put('M', 1000);

        char[] chars = s.toCharArray();
        char current;
        int result = 0, currentNumb, lastNumb = 0;
        for (char aChar : chars) {
            current = aChar;
            if (code.containsKey(current)) {
                currentNumb = code.get(current);
                if (currentNumb <= lastNumb) {
                    result = result + currentNumb;
                } else {
                    result = result - 2 * lastNumb + currentNumb;
                }
                lastNumb = currentNumb;
            } else {
                return 0;
            }
        }
        return result;
    }




    public int romanToInt1(String s) {
        Map<Character, Integer> memory = new HashMap<>();
        memory.put('I', 1);
        memory.put('V', 5);
        memory.put('X', 10);
        memory.put('L', 50);
        memory.put('C', 100);
        memory.put('D', 500);
        memory.put('M', 1000);

        char[] chars = s.toCharArray();
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length) {
                if (memory.get(chars[i]) >= memory.get(chars[i+1])) {
                    total += memory.get(chars[i]);
                } else {
                    total -= memory.get(chars[i]);
                }
            } else {
                total += memory.get(chars[i]);
            }
        }
        System.gc();
        return total;
    }


    public static void main(String[] args) {
//        System.out.println(romanToInt("LVIII"));


        Roman_to_Integer item = new Roman_to_Integer();
        System.out.println(item.romanToInt1("MLXVI"));
    }
}
