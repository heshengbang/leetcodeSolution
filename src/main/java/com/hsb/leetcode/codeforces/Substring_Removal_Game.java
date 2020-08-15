package com.hsb.leetcode.codeforces;

/*
 * 类描述:
 *************************************************
 */

import java.util.*;

public class Substring_Removal_Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        int s = Integer.parseInt(t);
        Substring_Removal_Game item = new Substring_Removal_Game();
        while (s -- > 0) {
            item.func1(in.nextLine());
        }
    }

    private void func1(String context) {
        List<Integer> contain = find(context);
        contain.sort((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return -1;
            }
        });
        int count = 0;
        for (int i = 1; i < contain.size() + 1; i++) {
            if (i % 2 == 1) {
                count += contain.get(i - 1);
            }
        }
        System.out.println(count);
    }

    private List<Integer> find(String context) {
        List<Integer> total = new ArrayList<>();
        int index = 0;
        while (index < context.length()) {
            int count = 0;
            while (index < context.length() && context.charAt(index) == '1') {
                count++;
                index++;
            }
            if (count > 0) {
                total.add(count);
            }
            index++;
        }
        return total;
    }
}
