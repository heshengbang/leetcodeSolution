package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/11/15 14:00
 * @version 1.0
 * @author heshengbang
 *************************************************
 */

/**
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 *
 *
 */
public class Guess_Number_Higher_or_Lower {
    private int pickNum = 1702766719;
    public int guessNumber(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int lower, int higher) {
        int mid = (int) (((long)lower + higher) / 2);
        if (guess(mid) == -1) {
            return binarySearch(lower, mid - 1);
        } else if (guess(mid) == 1) {
            return binarySearch(mid + 1, higher);
        }
        return mid;
    }

    private int guess(int num) {
        return Integer.compare(pickNum, num);
    }


    public static void main(String[] args) {
        Guess_Number_Higher_or_Lower item = new Guess_Number_Higher_or_Lower();
        System.out.println(item.guessNumber(2126753390));
    }
}
