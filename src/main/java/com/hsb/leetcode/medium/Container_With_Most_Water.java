package com.hsb.leetcode.medium;

/**
 * @author heshengbang
 * 2019/9/19.
 * https://github.com/heshengbang
 * www.heshengbang.men
 * email: trulyheshengbang@gmail.com
 */

/**
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int result = 0, left, right, current;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                left = height[i];
                right = height[j];
                current = (left < right ? left : right) * (j - i);
                if (result < current) {
                    result = current;
                }
            }
        }
        return result;
    }

    public int maxArea1(int[] height) {
        int result = 0, left = 0, right = height.length - 1, current;

        while (left < right) {
            if (height[left] < height[right]) {
                current = height[left] * (right - left);
                if (current > result) {
                    result = current;
                }
                left++;
            } else {
                current = height[right] * (right - left);
                if (current > result) {
                    result = current;
                }
                right--;
            }
        }
        return result;
    }

    public int maxArea2(int[] height) {
        int leftHigh = height[0], rightHigh = height[height.length - 1], leftIndex = 0, rightIndex = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (leftHigh < height[i]) {
                leftHigh = height[i];
                leftIndex = i;
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (rightHigh < height[i]) {
                rightHigh = height[i];
                rightIndex = i;
            }
        }
//        int maxArea = Math.min(leftHigh, rightHigh) * (rightIndex - leftIndex);
//
//        while (leftIndex >= 0 && rightIndex < height.length) {
//            if (leftIndex - 1 >= 0 && rightIndex + 1 < height.length) {
//                if (height[leftIndex - 1] < height[rightIndex + 1]) {
//                    rightIndex++;
//                } else if (height[leftIndex - 1] == height[rightIndex + 1]) {
//                    rightIndex++;
////                    leftIndex--;
//                } else {
//                    leftIndex--;
//                }
//            } else if (leftIndex - 1 >= 0) {
//                leftIndex--;
//            } else if (rightIndex + 1 < height.length) {
//                rightIndex++;
//            } else {
//                break;
//            }
//            maxArea = Math.max(maxArea, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
//        }

        int maxArea = 0;
        for (int i = leftIndex; i >= 0; i--) {
            for (int j = rightIndex; j < height.length; j++) {
                maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int[] case1 = {2,3,4,5,18,17,6};
//        int[] case1 = {1,8,6,2,5,4,8,8,3,7};
//        int[] case1 = {1,1};
//        int[] case1 = {0, 0, 0, 0, 0, 0};

        int[] case1 = {10,14,10,4,10,2,6,1,6,12};
        Container_With_Most_Water item = new Container_With_Most_Water();
        System.out.println(item.maxArea2(case1));
    }
}
