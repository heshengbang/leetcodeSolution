package com.hsb.leetcode.medium;

import java.util.*;

/**
 * Maximum Length of a Concatenated String with Unique Characters
 */

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    public static int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (String item: arr) {
            int binaryDesc = 0;
            for (int i = 0; i < item.length(); i++) {
                if ((binaryDesc & (1 << item.charAt(i) - 'a')) != 0) {
                    binaryDesc = 0;
                    break;
                } else {
                    binaryDesc = binaryDesc | (1 << item.charAt(i) - 'a');
                }
            }
            if (binaryDesc == 0) {
                continue;
            }

            List<Integer> tmp = new ArrayList<>();
            for (Integer binary: list) {
                if ((binary & binaryDesc) == 0) {
                    int count = binary | binaryDesc;
                    result = Math.max(result, Integer.bitCount(count));
                    tmp.add(count);
                }
                tmp.add(binary);
            }
            result = Math.max(result, Integer.bitCount(binaryDesc));
            tmp.add(binaryDesc);
            list = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}
