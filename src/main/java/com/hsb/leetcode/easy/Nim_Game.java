package com.hsb.leetcode.easy;

public class Nim_Game {
    public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        return nim(n - 1, false) || nim(n - 2, false) || nim(n - 3, false);
    }

    private static boolean nim(int restStone, boolean isMyself) {
        if (restStone <= 3) {
            return isMyself;
        }
        return nim(restStone - 1, !isMyself)
                || nim(restStone - 2, !isMyself)
                || nim(restStone - 3, !isMyself);
    }

    public static boolean canWinNim1(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim1(Integer.MAX_VALUE));
    }
}
