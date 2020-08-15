package com.hsb.leetcode.codeforces;

/*
 * @since 2020/8/15 0:28
 * @version 1.0
 */

import java.util.*;

public class Good_Subarrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        int s = Integer.parseInt(t);
        while (s -- > 0) {
            int size = Integer.parseInt(in.nextLine());
            String temp = in.nextLine();
            int sum = 0;
            Map<Integer, Long> save = new HashMap<>();
            save.put(0, 1L);
            for (int i = 1; i < size + 1; i++) {
                sum += (temp.charAt(i - 1) - '0');
                int type = sum - i;
                if (save.containsKey(type)) {
                    save.put(type, save.get(type) + 1);
                } else {
                    save.put(type, 1L);
                }
            }

            long total = 0;

            for (long l: save.values()) {
                if (l > 1) {
                    long count = (l * (l - 1)) / 2;
                    total +=  count;
                }
            }
            System.out.println(total);
        }
    }
}
