package com.hsb.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 1;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int length = intervals.length;
        int left = 0, right = left + 1;
        int result = 0;
        while (true) {
            if (intervals[right][0] <= intervals[left][1]) {
                intervals[left][1] = intervals[right][1];
            } else {
                result++;
                left = right;
            }
            right++;
            if (right == length) {
                result++;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        int[][] intervals = {{1,2},{1, 2},{1, 2}};
        Non_overlapping_Intervals it = new Non_overlapping_Intervals();
        System.out.println(it.eraseOverlapIntervals(intervals));
    }
}
