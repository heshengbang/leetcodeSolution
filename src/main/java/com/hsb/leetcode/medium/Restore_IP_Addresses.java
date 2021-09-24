package com.hsb.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Restore IP Addresses
 */

public class Restore_IP_Addresses {
    public static void main(String[] args) {
        Restore_IP_Addresses item = new Restore_IP_Addresses();
        System.out.println(item.restoreIpAddresses("222222222222222222222222222222222222222222222222222222222222222222222222222222"));
    }


    public List<String> restoreIpAddresses(String s) {
        // 1024 512  00000000 - 11111111
        return insertPoint(s, 3, 1);
    }

    private List<String> insertPoint(String s, int count, int index) {
        if (count == 0) {
            String[] items = s.split("\\.");
            if (items.length != 4) {
                return Collections.emptyList();
            }
            for (String item: items) {
                if (item.length() == 0 || item.length() > 3) {
                    return Collections.emptyList();
                } else {
                    if (item.startsWith("0") && item.length() > 1) {
                        return Collections.emptyList();
                    }
                    int tmp = Integer.parseInt(item);
                    if (tmp > 255 || tmp < 0) {
                        return Collections.emptyList();
                    }
                }
            }
            return Collections.singletonList(s);
        } else {
            if (index >= s.length()) {
                return Collections.emptyList();
            }
            List<String> list = new ArrayList<>();
            for (int i = index; i < index + 3 && i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, ".");
                list.addAll(insertPoint(sb.toString(), count - 1, i + 2));
            }
            return list;
        }
    }
}
