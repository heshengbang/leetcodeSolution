package com.hsb.leetcode.medium;

import java.util.*;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int left = 0, right = left + 1;
        int[] leftIntervals = intervals[left];
        while (right < length) {
            int[] rightIntervals = intervals[right];
            if (leftIntervals[1] < rightIntervals[0]) {
                list.add(leftIntervals);
                left = right;
                right = left + 1;
                leftIntervals = intervals[left];
            } else if (leftIntervals[1] >= rightIntervals[0] && leftIntervals[1] <= rightIntervals[1]) {
                leftIntervals[1] = rightIntervals[1];
                right++;
            } else {
                right++;
            }
            if (right == length) {
                list.add(leftIntervals);
            }
        }
        int[][] ans = new int[list.size()][2];
        ans = list.toArray(ans);
        return ans;
    }

    public int[][] merge1(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int[] tmp = intervals[0];
        for (int i = 1; i < length; i++) {
            if (tmp[0] > intervals[i][1]) {
                list.add(intervals[i]);
            } else if (tmp[1] < intervals[i][0]) {
                list.add(tmp);
                tmp = intervals[i];
            } else {
                tmp[0] = Math.min(tmp[0], intervals[i][0]);
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
            if (i + 1 == length) {
                list.add(tmp);
            }
        }
        int[][] ans = new int[list.size()][2];
        ans = list.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3}, {2,6}, {8,10},{15,18}};


        int[][] intervals = {{1,4}};


        Merge_Intervals it = new Merge_Intervals();
        int[][] ans = it.merge(intervals);
        System.out.println(ans);
    }
}
