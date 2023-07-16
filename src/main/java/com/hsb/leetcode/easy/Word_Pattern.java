package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/11/5 16:20
 * @version 1.0
 * @author heshengbnag
 *************************************************
 */

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arrays = str.split(" ");
        Map<String, Character> result1 = new HashMap<>();
        Map<Character, String> result2 = new HashMap<>();
        if (pattern.length() != arrays.length) {
            return false;
        }
        for (int i = 0; i < arrays.length; i++) {
            if (result1.containsKey(arrays[i])) {
                Character character = result1.get(arrays[i]);
                if (!character.equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                result1.put(arrays[i], pattern.charAt(i));
            }
            if (result2.containsKey(pattern.charAt(i))) {
                String string = result2.get(pattern.charAt(i));
                if (!string.equals(arrays[i])) {
                    return false;
                }
            } else {
                result2.put(pattern.charAt(i), arrays[i]);
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        char[] chars = pattern.toCharArray();
        HashMap<Character, String> memory = new HashMap<>();
        HashMap<String, Character> reverse = new HashMap<>();
        for (int i = 0; i < chars.length;i++) {
            if (memory.containsKey(chars[i])) {
                String tmp = memory.get(chars[i]);
                if (!tmp.equals(strings[i])) {
                    return false;
                }
            } else {
                memory.put(chars[i], strings[i]);
            }

            if (reverse.containsKey(strings[i])) {
                char ch = reverse.get(strings[i]);
                if (ch != chars[i]) {
                    return false;
                }
            } else {
                reverse.put(strings[i], chars[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Word_Pattern item = new Word_Pattern();
//        System.out.println(item.wordPattern1("aaa", "aa aa aa aa"));
//        System.out.println(item.wordPattern1("abba", "dog cat cat dog"));
//        System.out.println(item.wordPattern1("abba", "dog cat cat fish"));
//        System.out.println(item.wordPattern1("aaaa", "dog cat cat dog"));
        System.out.println(item.wordPattern1("abba", "dog dog dog dog"));
    }
}
