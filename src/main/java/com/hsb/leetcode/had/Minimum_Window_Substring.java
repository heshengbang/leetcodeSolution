package com.hsb.leetcode.had;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            if (i == 0) {
                count++;
            } else {
                int index = t.indexOf(ch);
                if (index == i) {
                    count++;
                }
            }
        }
        String ans = s;
        for (int i = 0; i < m; i++) {
            for (int j = i - count; j >= 0; j--) {
                String tmp = s.substring(j, i);
                if (findT(tmp, t)) {
                    if (ans.length() > tmp.length()) {
                        ans = tmp;
                    }
                }
            }
        }
        if (ans.equals(s)) {
            return "";
        } else {
            return ans;
        }
    }

    private boolean findT(String tmp, String t) {
        char[] chars = t.toCharArray();
        for (char ch: chars) {
            if (tmp.indexOf(Character.toString(ch)) == -1) {
                return false;
            }
        }
        return true;
    }
}
