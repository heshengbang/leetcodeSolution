package com.hsb.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while (left <= right) {
            if (isSelfDividingNumbers(left)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }

    private static boolean isSelfDividingNumbers(int left) {
        int o = left;
        while (o > 0) {
            int rest = o % 10;
            if (rest == 0 || left % rest != 0) {
                return false;
            }
            o = o / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }
}
