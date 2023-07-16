package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/11/5 18:44
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        char[] maps = new char[128];
        char[] mapt = new char[128];
        if (s.length() != t.length()) {
            return false;
        }
        char chS, chT;
        for (int i = 0 ; i < s.length(); i++) {
            chS = s.charAt(i);
            chT = t.charAt(i);
            if (maps[chS] == 0 && mapt[chT] == 0) {
                maps[chS] = chT;
                mapt[chT] = chS;
            } else if (maps[chS] != chT || mapt[chT] != chS) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        Map<Character, Character> memory = new HashMap<>();
        Map<Character, Character> reverseMemory = new HashMap<>();

        for (int i = 0; i < chS.length; i++) {
            if (!memory.containsKey(chS[i])) {
                memory.put(chS[i], chT[i]);
            } else {
                char tmp = memory.get(chS[i]);
                if (tmp != chT[i]) {
                    return false;
                }
            }

            if (!reverseMemory.containsKey(chT[i])) {
                reverseMemory.put(chT[i], chS[i]);
            } else {
                char tmp = reverseMemory.get(chT[i]);
                if (tmp != chS[i]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic_Strings item = new Isomorphic_Strings();
//        System.out.println(item.isIsomorphic1("paper", "title"));

//        System.out.println(item.isIsomorphic1("egg", "add"));

//        System.out.println(item.isIsomorphic1("foo", "bar"));

        System.out.println(item.isIsomorphic1("badc", "baba"));


    }
}
