package com.hsb.leetcode.easy;

public class Find_the_Highest_Altitude {
    public int largestAltitude(int[] gain) {
        int length = gain.length;
        int[] altitudes = new int[length + 1];
        altitudes[0] = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            altitudes[i + 1] = altitudes[i] + gain[i];
            result = Math.max(result, altitudes[i + 1]);
        }
        return result;
    }
}
