package com.hsb.leetcode.easy;


public class Easy_1_bit_and_2_bit_Characters {

    public boolean isOneBitCharacter(int[] bits) {
        return isEndWithOneBitCharacter(bits, 0);
    }

    private boolean isEndWithOneBitCharacter(int[] bits, int index) {
        if (index == bits.length - 2) {
            if (bits[index] == 0) {
                return bits[index + 1] == 0;
            } else {
                return false;
            }
        } else if (index == bits.length - 1) {
            return bits[index] == 0;
        }

        if (bits[index] == 0) {
            return isEndWithOneBitCharacter(bits, index + 1);
        } else {
            return isEndWithOneBitCharacter(bits, index + 2);
        }
    }

    public static void main(String[] args) {
        int[] param = {1,1,1,1,1,1,1,1,0};
        Easy_1_bit_and_2_bit_Characters item = new Easy_1_bit_and_2_bit_Characters();
        System.out.println(item.isOneBitCharacter(param));
    }
}
