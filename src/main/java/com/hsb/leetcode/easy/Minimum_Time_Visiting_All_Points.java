package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/2/7 21:13
 */

public class Minimum_Time_Visiting_All_Points {
    public int minTimeToVisitAllPoints(int[][] points) {
        int preX = points[0][0], preY = points[0][1], currentX, currentY, distance = 0, dfX, dfY;
        for (int i = 1; i < points.length; i++) {
            currentX = points[i][0];
            currentY = points[i][1];
            if (currentX >= preX && currentY >= preY) {
                dfX = currentX - preX;
                dfY = currentY - preY;
            } else if (currentX < preX && currentY >= preY) {
                dfX = preX - currentX;
                dfY = currentY - preY;
            } else if (currentX >= preX) {
                dfX = currentX - preX;
                dfY = preY - currentY;
            } else {
                dfX = preX - currentX;
                dfY = preY - currentY;
            }
            distance += (Math.max(dfX, dfY));
            preX = currentX;
            preY = currentY;
        }
        return distance;
    }

    public static void main(String[] args) {
        Minimum_Time_Visiting_All_Points item = new Minimum_Time_Visiting_All_Points();
        int[][] param = {{3,2},{-2,2}};
        System.out.println(item.minTimeToVisitAllPoints(param));
    }
}
