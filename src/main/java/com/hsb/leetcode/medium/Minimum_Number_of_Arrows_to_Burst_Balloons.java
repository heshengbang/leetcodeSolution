package com.hsb.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int ans = 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int[] overlapping = points[0];
        for (int i = 1; i < points.length; i++) {
            // 当前区间在之前重叠区间的右侧，并且完全没有交集
            if (overlapping[1] < points[i][0]) {
                // 重叠区间可以算作一支箭
                ans++;
                // 将当前区间当作最新的重叠区间
                overlapping = points[i];
            } else if (overlapping[1] <= points[i][1]) {
                if (overlapping[0] < points[i][0]) {
                    // 取交集
                    overlapping[0] = points[i][0];
                } else if (points[i][0] <= overlapping[0]) {
                    // 重叠区间在当前区间内部，什么都不做
                }
            } else if (points[i][1] < overlapping[1]){
                if (overlapping[0] < points[i][0]) {
                    // 当前区间在之前的重叠区间的内部，取交集
                    overlapping[0] = points[i][0];
                    overlapping[1] = points[i][1];
                } else {
                    if (overlapping[0] <= points[i][1]) {
                        overlapping[1] = points[i][1];
                    } else {
                        // 重叠区间在当前区间的右侧，并且完全没有交集，这种情况不太可能发生，因为points是排序过的
                    }
                }
            }
        }
        ans++;
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        Minimum_Number_of_Arrows_to_Burst_Balloons it = new Minimum_Number_of_Arrows_to_Burst_Balloons();
        System.out.println(it.findMinArrowShots(points));
    }
}
