package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/2/5 22:06
 */

public class Add_Strings {
    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        StringBuilder result = new StringBuilder();
        boolean carry = false;
        int n1, n2;
        for (int i = 0; i < length; i++) {
            if (num1.length() - 1 >= i) {
                n1 = num1.charAt(num1.length() - 1 - i) - '0';
            } else {
                n1 = 0;
            }
            if (num2.length() - 1 >= i) {
                n2 = num2.charAt(num2.length() - 1 - i) - '0';
            } else {
                n2 = 0;
            }
            int sum = n1 + n2;
            if (carry) {
                sum++;
            }
            if (sum > 9) {
                result.insert(0, sum % 10);
                carry = true;
            } else {
                result.insert(0, sum);
                carry = false;
            }
        }
        if (carry) {
            result.insert(0, "1");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Add_Strings item = new Add_Strings();
        System.out.println(item.addStrings("6913259244", "71103343"));
    }
}
