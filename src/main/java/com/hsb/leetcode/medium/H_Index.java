package com.hsb.leetcode.medium;

public class H_Index {

    public int hIndex(int[] citations) {
        int length = citations.length;
        for (int i = length; i > 0; i--) {
            int count = i, j = 0;
            while (count > 0 && j < length && count <= length - j) {
                if (citations[j] >= i) {
                    count--;
                }
                j++;
            }
            if (count == 0) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        int length = citations.length;
        int[] counts = new int[citations.length + 1];
        for (int c: citations) {
            if (c >= length) {
                counts[length]++;
            } else {
                counts[c]++;
            }
        }
        int count = 0;
        for (int h = length; h >= 0; h--) {
            count = count + counts[h];
            if (count >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        H_Index item = new H_Index();
//        int[] nums = {1,3,1};
//        // 0 2 0 1
//        System.out.println(item.hIndex2(nums));

        H_Index item = new H_Index();
        int[] nums = {3,0,6,1,5};
        //   1 1 0 1 0 2
        System.out.println(item.hIndex2(nums));
    }

}
