package com.hsb.leetcode.medium;

/*
 * 类描述:
 * @since 2019/11/10 17:34
 * @version 1.0
 *************************************************
 */

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations3(String digits) {
        return new AbstractList<String>() {
            private String[] elements;
            private Map<Character, String[]> map;
            @Override
            public String get(int index) {
                if (elements == null) {
                    if (digits.length() == 0) {
                        elements = new String[0];
                    } else {
                        elements = getLetter1(digits.toCharArray(), 0);
                    }
                }
                return elements[index];
            }

            private String[] getLetter1(char[] chars, int index) {
                if (chars.length == 0) {
                    return new String[0];
                }
                if (map == null) {
                    map = new HashMap<>();
                    map.put('2', new String[]{"a", "b", "c"});
                    map.put('3', new String[]{"d", "e", "f"});
                    map.put('4', new String[]{"g", "h", "i"});
                    map.put('5', new String[]{"j", "k", "l"});
                    map.put('6', new String[]{"m", "n", "o"});
                    map.put('7', new String[]{"p", "q", "r", "s"});
                    map.put('8', new String[]{"t", "u", "v"});
                    map.put('9', new String[]{"w", "x", "y", "z"});
                }
                if (index == chars.length - 1) {
                    return map.get(chars[index]);
                }
                String[] pres = getLetter1(chars, index + 1);
                String[] cur = map.get(chars[index]);
                String[] result = new String[pres.length * cur.length];
                int count = 0;
                for (String it: cur) {
                    for (String pre: pres) {
                        result[count] = it + pre;
                        count++;
                    }
                }
                return result;
            }

            @Override
            public int size() {
                if (elements == null) {
                    elements = getLetter1(digits.toCharArray(), 0);
                }
                return elements.length;
            }
        };
    }

    private Map<Character, List<String>> mem;
    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        mem = new HashMap<>();
        mem.put('2', Arrays.asList("a", "b", "c"));
        mem.put('3', Arrays.asList("d", "e", "f"));
        mem.put('4', Arrays.asList("g", "h", "i"));
        mem.put('5', Arrays.asList("j", "k", "l"));
        mem.put('6', Arrays.asList("m", "n", "o"));
        mem.put('7', Arrays.asList("p", "q", "r", "s"));
        mem.put('8', Arrays.asList("t", "u", "v"));
        mem.put('9', Arrays.asList("w", "x", "y", "z"));

        return getLetter(digits.toCharArray(), 0);
    }

    private List<String> getLetter(char[] chars, int index) {
        if (index == chars.length - 1) {
            return mem.get(chars[index]);
        }
        List<String> pres = getLetter(chars, index + 1);
        List<String> cur = mem.get(chars[index]);
        List<String> result = new ArrayList<>();
        for (String it: cur) {
            for (String pre: pres) {
                result.add(it + pre);
            }
        }
        return result;
    }


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
        List<String> results = item.letterCombinations3("2");
        System.out.println(results);
    }
}
