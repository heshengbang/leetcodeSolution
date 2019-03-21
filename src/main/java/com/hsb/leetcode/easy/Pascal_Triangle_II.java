package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/21 9:01
 *
 * @author heshengbang
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Pascal's Triangle II
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 *
 */
public class Pascal_Triangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = null;
        List<Integer> before = null;
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                result = new ArrayList<>();
                result.add(1);
            } else if (i == 1) {
                result = new ArrayList<>();
                result.add(1);
                result.add(1);
            } else {
                result = new ArrayList<>();
                result.add(1);
                for (int j = 1; j < before.size(); j++) {
                    result.add(before.get(j - 1) + before.get(j));
                }
                result.add(1);
            }
            before = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
    }
}
