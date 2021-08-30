package com.hsb.leetcode.easy;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static List<String> fizzBuzz1(int n) {
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                index++;

                int t3 = index % 3;
                int t5 = index % 5;

                if (t3 == 0 && t5 == 0) {
                    return "FizzBuzz";
                } else if (t3 == 0) {
                    return "Fizz";
                } else if (t5 == 0) {
                    return "Buzz";
                } else {
                    return String.valueOf(index);
                }
            }

            @Override
            public int size() {
                return n;
            }
        };
    }


    public static void main(String[] args) {
        System.out.println(fizzBuzz1(15));
    }
}
