package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/3/20 8:51
 *
 * @author heshengbang
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        int count = 1;
        while (count <= numRows) {
            if (count <= 2) {
                results.add(count(Collections.emptyList(), count));
            } else {
                results.add(count(results.get(count - 2), count));
            }
            count++;
        }
        return results;
    }

    public static List<Integer> count(List<Integer> list, int row) {
        if (row == 1) {
            return new ArrayList<>(Collections.singletonList(1));
        } else if (row == 2) {
            return new ArrayList<>(Arrays.asList(1, 1));
        } else {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            for (int i = 1; i < list.size(); i++) {
                result.add(list.get(i - 1) + list.get(i));
            }
            result.add(1);
            return result;
        }
    }

    public static void main(String[] args) {

        System.out.println(generate(5));
    }
}
