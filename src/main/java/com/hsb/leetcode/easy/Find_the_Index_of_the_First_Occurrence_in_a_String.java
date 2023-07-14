package com.hsb.leetcode.easy;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "sad", needle = "sadbutsad";
        Find_the_Index_of_the_First_Occurrence_in_a_String item = new Find_the_Index_of_the_First_Occurrence_in_a_String();
        System.out.println(item.strStr(haystack, needle));
    }
}
