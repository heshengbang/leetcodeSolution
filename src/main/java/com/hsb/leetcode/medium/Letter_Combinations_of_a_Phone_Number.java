package com.hsb.leetcode.medium;

/*
 * 类描述:
 * @since 2019/11/10 17:34
 * @version 1.0
 *************************************************
 */

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> results = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            List<Character> temp = map.get(digits.charAt(i));
            if (temp == null) {
                continue;
            }
            if (results.size() == 0) {
                for (Character ch : temp) {
                    results.add(String.valueOf(ch));
                }
            } else {
                List<String> newTemp = new ArrayList<>();
                for (Character ch : temp) {
                    for (String string: results) {
                        newTemp.add(string + ch);
                    }
                }
                results = newTemp;
            }
        }
        return results;
    }


    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number item = new Letter_Combinations_of_a_Phone_Number();
        List<String> results = item.letterCombinations("23");
        System.out.println(results);
    }
}
