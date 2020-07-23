package com.hsb.leetcode.had;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @since 2020/7/22 17:57
 */

public class Interleaving_String {
    private Map<String, Boolean> cache = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        String key = s1 + "-" + s2 + "-" + s3;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean result = (s1.substring(0, 1).equals(s3.substring(0, 1))&&isInterleave(s1.substring(1), s2, s3.substring(1))) || (s2.substring(0, 1).equals(s3.substring(0, 1))&&isInterleave(s1, s2.substring(1), s3.substring(1)));
        cache.put(key, result);
        return result;
    }



    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] status = new boolean[s1.length() + 1][s2.length() + 1];
        String[][] result = new String[s1.length() + 1][s2.length() + 1];
        result[0][0] = "";
        status[0][0] = true;
        for (int k = 1; k < s1.length() + 1; k++) {
            result[k][0] = s1.substring(0, k);
            if (s3.startsWith(result[k][0])) {
                status[k][0] = true;
            }
        }
        for (int k = 1; k < s2.length() + 1; k++) {
            result[0][k] = s2.substring(0, k);
            if (s3.startsWith(result[0][k])) {
                status[0][k] = true;
            }
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (status[i][j - 1]) {
                    if (s3.startsWith(result[i][j - 1] + s2.charAt( j - 1))) {
                        status[i][j] = true;
                        result[i][j] = result[i][j - 1] + s2.charAt( j - 1);
                    }
                }
                if (status[i - 1][j]) {
                    if (s3.startsWith(result[i - 1][j] + s1.charAt(i - 1))) {
                        status[i][j] = true;
                        result[i][j] = result[i - 1][j] + s1.charAt(i - 1);
                    }
                }
            }
        }
        return status[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Interleaving_String item = new Interleaving_String();
        System.out.println(item.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
