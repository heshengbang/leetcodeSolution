package com.hsb.leetcode.medium;

/**
 * @version 1.0
 * @since 2020/2/8 14:40
 */

public class MyCalendarI {
    private int[][] results;
    public MyCalendarI() {
        results = new int[0][2];
    }

    public boolean book(int start, int end) {
        if (results.length == 0) {
            results = new int[][]{{start, end - 1}};
            return true;
        } else {
            int[][] temp = new int[results.length + 1][2];
            for (int i = 0; i < results.length; i++) {
                if (results[i][0] >= end || results[i][1] < start) {
                    temp[i][0] = results[i][0];
                    temp[i][1] = results[i][1];
                } else {
                    return false;
                }
            }
            temp[results.length][0] = start;
            temp[results.length][1] = end - 1;
            results = temp;
            return true;
        }
    }

    public static void main(String[] args) {
        /*
         *
         * ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
         * [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
         *
         * [null,true,true,false,false,true,false,true,true,true,false]
         *
         */
        MyCalendarI item = new MyCalendarI();
        System.out.println(item.book(47,50));
        System.out.println(item.book(33,41));
        System.out.println(item.book(39,45));
        System.out.println(item.book(33,42));
        System.out.println(item.book(25,32));
        System.out.println(item.book(26,35));
        System.out.println(item.book(19,25));
        System.out.println(item.book(3,8));
        System.out.println(item.book(8,13));
        System.out.println(item.book(18,27));
    }
}
