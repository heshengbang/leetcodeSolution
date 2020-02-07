package com.hsb.leetcode.easy;

/**
 * @version 1.0
 * @since 2020/2/7 22:04
 */

public class Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        int[] jewels= new int['z' - 'A' + 1];
        for (char ch: J.toCharArray()) {
            jewels[ch - 'A']++;
        }
        int count = 0;
        for (char ch: S.toCharArray()) {
            if (jewels[ch - 'A']==1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Jewels_and_Stones item = new Jewels_and_Stones();
        System.out.println(item.numJewelsInStones("z", "ZZ"));
    }
}
