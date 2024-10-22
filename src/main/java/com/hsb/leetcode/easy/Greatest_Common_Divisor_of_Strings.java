package com.hsb.leetcode.easy;

public class Greatest_Common_Divisor_of_Strings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String s1 = "ABABAB", s2 = "ABAB";
//        String s1 = "LEET", s2 = "CODE";

        Greatest_Common_Divisor_of_Strings item = new Greatest_Common_Divisor_of_Strings();
        System.out.println(item.gcdOfStrings(s1, s2));
    }
}
