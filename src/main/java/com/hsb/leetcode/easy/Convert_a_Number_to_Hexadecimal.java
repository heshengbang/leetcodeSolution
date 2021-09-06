package com.hsb.leetcode.easy;

public class Convert_a_Number_to_Hexadecimal {


    public String toHex(int num) {
        if ( num == 0) {
            return "0";
        }
        char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String bitString = Integer.toBinaryString(num);
        StringBuilder result = new StringBuilder();
        while (bitString.length() > 0) {
            if (bitString.length() <= 4) {
                result.insert(0, table[Integer.valueOf(bitString, 2)]);
                bitString = "";
            } else {
                String tmp = bitString.substring(bitString.length() - 4);
                result.insert(0, table[Integer.valueOf(tmp, 2)]);
                bitString = bitString.substring(0, bitString.length() - 4);
            }
        }
        return result.toString();
    }

    public String toHex1(int num) {
        if(num == 0) {
            return "0";
        }
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[(num & 15)]);
            num = (num >>> 4);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Convert_a_Number_to_Hexadecimal item = new Convert_a_Number_to_Hexadecimal();
        System.out.println(item.toHex1(26));

    }
}
