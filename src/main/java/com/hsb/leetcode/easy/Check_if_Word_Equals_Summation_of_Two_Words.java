package com.hsb.leetcode.easy;

public class Check_if_Word_Equals_Summation_of_Two_Words {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] ch1 = firstWord.toCharArray();
        char[] ch2 = secondWord.toCharArray();
        char[] ch3 = targetWord.toCharArray();

        int[] int1 = char2int(ch1);

        int[] int2 = char2int(ch2);

        int[] int3 = char2int(ch3);

        int param1 = intArray2int(int1);

        int param2 = intArray2int(int2);

        int param3 = intArray2int(int3);

        return param1 + param2 == param3;
    }

    public int[] char2int(char[] chs) {
        int[] ints = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            ints[i] = chs[i] - 'a';
        }
        return ints;
    }

    public int intArray2int(int[] ints) {
        int multiple = 1;
        int param = 0;
        for (int i = ints.length - 1; i >= 0;i--) {
            param = param + ints[i] * multiple;
            multiple = multiple * 10;
        }
        return param;
    }

    public static void main(String[] args) {
        Check_if_Word_Equals_Summation_of_Two_Words item = new Check_if_Word_Equals_Summation_of_Two_Words();
        System.out.println(item.isSumEqual("jjjjjjjj", "jjjjjjjj", "bjjjjjjji"));
    }
}
