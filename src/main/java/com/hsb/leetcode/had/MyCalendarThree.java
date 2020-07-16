package com.hsb.leetcode.had;

import java.util.Objects;

/**
 * @version 1.0
 * @since 2020/2/10 20:57
 */

public class MyCalendarThree {
    private static class Tree{
        Tree left;
        Tree right;
        int start, end;
        int time;
        public Tree(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    private Tree root;
    int k = 0;

    public int book(int start, int end) {
        if (root == null) {
            root = new Tree(start, end, 1);
            k = Math.max(k, 1);
        } else {
            int time = insert(root, start, end, 1);
            k = Math.max(k, time);
        }
        return k;
    }

    private int insert(Tree root, int start, int end, int time) {
        int k = 0;
        if (end <= root.start) {
            if (root.left == null) {
                root.left = new Tree(start, end, time);
                k = Math.max(k, time);
            } else {
                int result = insert(root.left, start, end, time);
                k = Math.max(k, result);
            }
        } else if (start >= root.end) {
            if (root.right == null) {
                root.right = new Tree(start, end, time);
                k = Math.max(k, time);
            } else {
                int result = insert(root.right, start, end, time);
                k = Math.max(k, result);
            }
        } else if (start == root.start && end == root.end) {
            root.time += time;
            k = Math.max(k, root.time);
        } else {

            int a = Math.min(start, root.start);
            int b = Math.max(start, root.start);
            int c = Math.min(end, root.end);
            int d = Math.max(end, root.end);

            if (start == a) {
                if (root.left == null) {
                    root.left = new Tree(a, b, time);
                    k = Math.max(k, time);
                } else {
                    int result = insert(root.left, a, b, time);
                    k = Math.max(k, result);
                }
            } else {
                if (root.left == null) {
                    root.left = new Tree(a, b, root.time);
                    k = Math.max(k, root.time);
                } else {
                    int result = insert(root.left, a, b, root.time);
                    k = Math.max(k, result);
                }
            }
            if (d == end) {
                if (root.right == null) {
                    root.right = new Tree(c, d, time);
                    k = Math.max(k, time);
                } else {
                    int result = insert(root.right, c, d, time);
                    k = Math.max(k, result);
                }
            } else {
                if (root.right == null) {
                    root.right = new Tree(c, d, root.time);
                    k = Math.max(k, root.time);
                } else {
                    int result = insert(root.right, c, d, root.time);
                    k = Math.max(k, result);
                }
            }

            root.start = b;
            root.end = c;
            root.time += time;

            k = Math.max(k, root.time);
        }
        return k;
    }


    public static void main(String[] args) {
        test3();
    }

    private static boolean test4() {
        MyCalendarThree myCalendarTwo = new MyCalendarThree();
        int[][] param = {{97,100}, {51,65}, {27,46}, {90,100}, {20,32},
                {15,28},
                {60,73}, {77,91},{67,85},{58,72},{74,93},{73,83},{71,87},{97,100},{14,31},
                {26,37}, {66,76},{52,67},{24,43}, {6,23},
                {94,100},{33,44},{30,46}, {6,20},{71,87},{49,59},{38,55},{4,17},{46,61},{13,31},
                {94,100},{47,65},{9,25},
                {4,20},{2,17},{28,42}, {26,38}, {72,83},{43,61},{18,35}};
        int[] expected = {1,1,1,2,2,3,3,3,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,8,9,9,9,9,9,10};
        for (int i = 0; i < param.length; i++) {
            // 20
            int actual = myCalendarTwo.book(param[i][0], param[i][1]);
            if (!Objects.equals(actual, expected[i])) {
                System.out.println(i + "   " +  param[i][0] + "   "  + param[i][1]  + "    " + actual + "          " + expected[i]);
                return false;
            }
        }
        return true;
    }

    private static boolean test3() {
        MyCalendarThree myCalendarTwo = new MyCalendarThree();
        int[][] param = {{5,12},{42,50},{4,9},{33,41},{2,7},{16,25},{7,16},{6,11},{13,18},{38,43},{49,50},{6,15},{5,13},{35,42},{19,24},{46,50},{39,44},{28,36},{28,37},{20,29},{41,49},{11,19},{41,46},{28,37},{17,23},{22,31},{4,10},{31,40},{4,12},{19,26}};
        int[] expected = {1,1,2,2,3,3,3,4,4,4,4,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,8,8};
        for (int i = 0; i < param.length; i++) {
            int actual = myCalendarTwo.book(param[i][0], param[i][1]);
            if (!Objects.equals(actual, expected[i])) {
                System.out.println(i + "   " +  param[i][0] + "   "  + param[i][1]  + "    " + actual + "          " + expected[i]);
                return false;
            }
        }
        return true;
    }

    private static boolean test2() {
        MyCalendarThree myCalendarTwo = new MyCalendarThree();
        int[][] param = {{47,50},{1,10},{27,36},{40,47},{20,27},{15,23},{10,18},{27,36},{17,25},{8,17},{24,33},{23,28},{21,27},{47,50},{14,21},{26,32},{16,21},{2,7},{24,33},{6,13},{44,50},{33,39},{30,36},{6,15},{21,27},{49,50},{38,45},{4,12},{46,50},{13,21}};
        int[] expected = {1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7};
        for (int i = 0; i < param.length; i++) {
            int actual = myCalendarTwo.book(param[i][0], param[i][1]);
            if (!Objects.equals(actual, expected[i])) {
                System.out.println(i + "   " +  param[i][0] + "   "  + param[i][1] + " actual = " + actual + "   expected = " + expected[i]);
                return false;
            }
        }
        return true;
    }

    private static boolean test1() {
        MyCalendarThree myCalendarTwo = new MyCalendarThree();
        int[][] param = {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        int[] expected = {1, 1, 2, 3, 3, 3};
        for (int i = 0; i < param.length; i++) {
            if (!Objects.equals(myCalendarTwo.book(param[i][0], param[i][1]), expected[i])) {
                System.out.println(i + "   " +  param[i][0] + "   "  + param[i][1] + "          " + expected[i]);
                return false;
            }
        }
        return true;
    }
}
