package com.hsb.leetcode.easy;

/*
 * @author heshengbang
 * 2019/9/29.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 */
public class Add_Digits {
    public int addDigits1(int num) {
        if (num < 10) {
            return num;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }


    public int addDigits(int num) {
        return fuckDigits(num);
    }

    private int fuckDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num >= 10) {
            sum = sum + num % 10;
            num = num / 10;
        }
        sum = sum + num;
        if (sum < 10) {
            return sum;
        } else {
            return fuckDigits(sum);
        }
    }

    public static void main(String[] args) {
        Add_Digits item = new Add_Digits();
        System.out.println(item.addDigits1(111));
    }
}
