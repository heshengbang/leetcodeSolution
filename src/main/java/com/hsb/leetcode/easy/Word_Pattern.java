package com.hsb.leetcode.easy;

/*
 * 类描述:
 * Copyright 多点生活（成都）科技有限公司
 * @since 2019/11/5 16:20
 * @version 1.0
 * @author hu.he@dmall.com 何虎
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

    public static void main(String[] args) {
        Word_Pattern item = new Word_Pattern();
        System.out.println(item.wordPattern("aaa", "aa aa aa aa"));
    }
}