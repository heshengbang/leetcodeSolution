package com.hsb.leetcode.easy;

public class Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlanted = 0, length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                continue;
            }

            if (i + 1 < length && flowerbed[i + 1] == 1) {
                continue;
            }

            flowerbed[i] = 1;
            canPlanted++;
        }
        return canPlanted >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        Can_Place_Flowers it = new Can_Place_Flowers();
        System.out.println(it.canPlaceFlowers(flowerbed, n));
    }
}
