package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/11/5 18:44
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

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

    public static void main(String[] args) {
        Isomorphic_Strings item = new Isomorphic_Strings();
        System.out.println(item.isIsomorphic("paper", "title"));
    }
}
