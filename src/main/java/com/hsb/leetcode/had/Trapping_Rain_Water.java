package com.hsb.leetcode.had;

/**
 *
 * Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * https://leetcode.com/problems/trapping-rain-water
 *
 */
public class Trapping_Rain_Water {
    // didn't use dp so have low time efficiency
    public int trap1(int[] height) {
        int total = 0;
        int leftHigh = -1, leftHighIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (leftHigh < height[i]) {
                leftHigh = height[i];
                leftHighIndex = i;
            }
        }
        int rightHigh = -1, rightHighIndex = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (rightHigh < height[i]) {
                rightHigh = height[i];
                rightHighIndex = i;
            }
        }
        if (leftHighIndex != rightHighIndex) {
            total += countWater(leftHighIndex, rightHighIndex, rightHigh, height);
        }
        total += findToLeft(height, leftHighIndex);
        total += findToRight(height, rightHighIndex);
        return total;
    }

    private int findToLeft(int[] height, int endIndex) {
        if (endIndex <= 1) {
            return 0;
        }
        int high = -1, highIndex = -1;
        for (int i = 0; i < endIndex; i++) {
            if (high < height[i]) {
                high = height[i];
                highIndex = i;
            }
        }
        int total = 0;
        total += countWater(highIndex, endIndex, high, height);
        total += findToLeft(height, highIndex);
        return total;
    }

    private int findToRight(int[] height, int startIndex) {
        if (startIndex >= height.length - 2) {
            return 0;
        }
        int high = -1, highIndex = -1;
        for (int i = height.length - 1; i > startIndex; i--) {
            if (high < height[i]) {
                high = height[i];
                highIndex = i;
            }
        }
        int total = 0;
        total += countWater(startIndex, highIndex, high, height);
        total += findToRight(height, highIndex);
        return total;
    }

    private int countWater(int left, int right, int high, int[] height) {
        int total = 0;
        for (int i = left + 1; i < right; i++) {
            total += (high - height[i]);
        }
        return total;
    }

    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int[] height = {4,2,0,3,2,5};
        Trapping_Rain_Water item = new Trapping_Rain_Water();
        System.out.println(item.trap1(height));
    }
}
