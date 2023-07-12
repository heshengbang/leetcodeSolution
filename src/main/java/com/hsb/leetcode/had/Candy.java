package com.hsb.leetcode.had;

import java.util.Arrays;

/**
 * Candy
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * https://leetcode.com/problems/candy/?envType=study-plan-v2&envId=top-interview-150
 */
public class Candy {
        public int candy(int[] ratings) {
            int[] candy = new int[ratings.length];
            Arrays.fill(candy, 1);
            for ( int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    candy[i] = candy[i - 1] + 1;
                }
            }
            int total = 0;
            for ( int i = ratings.length - 1; i > 0; i--) {
                total += candy[i];
                if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                    candy[i - 1] = candy[i] + 1;
                }
            }
            total += candy[0];
            return total;
    }


    // bad solution
    public int candy2(int[] ratings) {
        int lowIndex = -1, low = 20001;
        for (int i = 0; i < ratings.length; i++) {
            if (low >= ratings[i]) {
                low = ratings[i];
                lowIndex = i;
            }
        }
        int left = lowIndex - 1, right = lowIndex + 1;
        int[] candy = new int[ratings.length];
        candy[lowIndex] = 1;
        while (left >= 0 || right < ratings.length) {
            // left to 0;
            if (left >= 0) {
                if (ratings[left] > ratings[left + 1]) {
                    candy[left] = candy[left + 1] + 1;
                } else if (ratings[left] == ratings[left + 1]) {
                    if (candy[left + 1] > 1) {
                        candy[left] = candy[left + 1] - 1;
                    } else {
                        candy[left] = candy[left + 1];
                    }
                } else {
                    if (candy[left + 1] > 1) {
                        candy[left] = candy[left + 1] - 1;
                    }
                }
            }
            left--;

            // right to ratings.length - 1
            if (right < ratings.length) {
                if (ratings[right] > ratings[right - 1]) {
                    candy[right] = candy[right - 1] + 1;
                } else if (ratings[right] == ratings[right - 1]) {
                    if (candy[right - 1] > 1) {
                        candy[right] = candy[right - 1] - 1;
                    } else {
                        candy[right] = candy[right - 1];
                    }
                } else {
                    if (candy[right - 1] > 1) {
                        candy[right] = candy[right - 1] - 1;
                    }
                }
            }
            right++;
        }
        int total = 0;
        for (int c : candy) {
            total += c;
        }
        return total;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();

//        int[] nums = {1,0,2};
//        int[] nums = {1,2,2};

        int[] nums = {1,2,87,87,87,2,1};


        System.out.println(candy.candy(nums));
    }
}
