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
        status[0][0] = true;
        for (int k = 1; k < s1.length() + 1; k++) {
            status[k][0] = status[k - 1][0] && s3.charAt(k - 1) == s1.charAt(k - 1);
        }
        for (int k = 1; k < s2.length() + 1; k++) {
            status[0][k] = status[0][k - 1] && s3.charAt(k - 1) == s2.charAt(k - 1);
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                status[i][j] = (status[i - 1][j]&&s1.charAt(i - 1) == s3.charAt(j + i - 1)) || (status[i][j - 1]&&s2.charAt(j - 1) == s3.charAt(i + j - 1));
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
