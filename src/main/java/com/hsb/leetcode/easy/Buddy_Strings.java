package com.hsb.leetcode.easy;

/**
 * 类描述:
 *
 * @author heshengbang
 * @version 1.0
 * @since 2019/9/30 23:11
 */

/**
 *
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A
 * so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 *
 */
public class Buddy_Strings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2) {
            return false;
        }
        if (A.equals(B)) {
            for (int i = 0; i < A.length() - 1; i++) {
                if (A.indexOf(A.charAt(i), i+ 1) != -1) {
                    return true;
                }
            }
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        StringBuilder subA = new StringBuilder();
        StringBuilder subB = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                continue;
            }
            subA.append(A.charAt(i));
            subB.append(B.charAt(i));
        }
        return subA.toString().equals(subB.toString()) || subA.reverse().toString().equals(subB.toString());
    }

    public static void main(String[] args) {
        Buddy_Strings item = new Buddy_Strings();
        System.out.println(item.buddyStrings("ab", "ba"));
    }
}
