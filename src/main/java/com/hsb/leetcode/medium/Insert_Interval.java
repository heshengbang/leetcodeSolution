package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        List<int[]> list = new ArrayList<>();
        boolean hasInsert = false;
        if (length == 0) {
            list.add(newInterval);
            hasInsert = true;
        }

        for (int i = 0; i < length; i++) {
            if (hasInsert) {
                list.add(intervals[i]);
                continue;
            }
            if (newInterval[1] < intervals[i][0]) {
                // 新的区间如果在左边，且不重叠
                list.add(newInterval);
                list.add(intervals[i]);
                hasInsert = true;
            } else if (newInterval[1] <= intervals[i][1]) {
                // 此处的隐含条件是intervals[i][0] <= newInterval[1]
                if (newInterval[0] < intervals[i][0]) {
                    // 新的区间会重叠，x0 < y0 < x1 < y1
                    newInterval[1] = intervals[i][1];
                } else {
                    // 隐含条件intervals[i][0] <= newInterval[0] <= newInterval[1]  <= intervals[i][1]
                    // 新的区间被包含，y0 < x0 < x1 < y1
                    list.add(intervals[i]);
                    hasInsert = true;
                }
            } else {
                // 隐含条件intervals[i][1] < newInterval[1]
                if (newInterval[0] < intervals[i][0]) {
                    // 新的区间包含了被比较的区间，x0 < y0 < y1 < x1
                    // 什么都不做
                } else if (newInterval[0] <= intervals[i][1]) {
                    // 隐含条件 intervals[i][0] <= newInterval[0] <= intervals[i][1] < newInterval[1]
                    // y0 <= x1 <= y1 < x1
                    newInterval[0] = intervals[i][0];
                } else {
                    // 隐含条件 intervals[i][1] < newInterval[0]
                    // 新的区间在右边，且不重叠
                    list.add(intervals[i]);
                }
            }
        }
        if (!hasInsert) {
            list.add(newInterval);
        }
        int[][] ans = new int[list.size()][2];
        ans = list.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2, 5};

//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {4,8};

//        int[][] intervals = {};
//        int[] newInterval = {5,7};

        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};

        Insert_Interval it = new Insert_Interval();
        System.out.println(it.insert(intervals, newInterval));
    }
}
