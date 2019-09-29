package com.hsb.leetcode.easy;

import java.util.*;

/**
 * @author heshengbang
 * 2019/9/28.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 *
 */
public class Minimum_Absolute_Difference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr.length < 2) {
            return Collections.emptyList();
        }
        Arrays.sort(arr);
        List<Integer> integerList;
        Map<Integer, List<List<Integer>>> results = new HashMap<>();
        List<List<Integer>> lists;
        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i-1];
            integerList = new ArrayList<>();
            integerList.add(arr[i - 1]);
            integerList.add(arr[i]);
            if (results.get(difference) == null) {
                lists = new ArrayList<>();
            } else {
                lists = results.get(difference);
            }
            lists.add(integerList);
            results.put(difference, lists);
        }
        List<Integer> integers = new ArrayList<>(results.keySet());
        Collections.sort(integers);
        return results.get(integers.get(0));
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, List<Integer>> result = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int currentMinimum = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (i == j || arr[i] < arr[j]) {
                    continue;
                }
                int diff = arr[i] - arr[j];
                if (currentMinimum > diff) {
                    currentMinimum = diff;
                    list.clear();
                    list.add(arr[j]);
                    list.add(arr[i]);
                }
            }
            if (list.size() == 0) {
                continue;
            }
            if (currentMinimum < min) {
                min = currentMinimum;
                result.clear();
                result.put(list.get(0), list);
            } else if (currentMinimum == min) {
                result.put(list.get(0), list);
            }
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        Minimum_Absolute_Difference item = new Minimum_Absolute_Difference();
        List<List<Integer>> results = item.minimumAbsDifference2(new int[]{1,3,6,10,15});
        for (List<Integer> list : results) {
            for (Integer integer: list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
