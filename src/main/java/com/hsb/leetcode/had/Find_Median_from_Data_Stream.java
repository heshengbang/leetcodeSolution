package com.hsb.leetcode.had;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Find_Median_from_Data_Stream {
    private ArrayList<Integer> mem;
    private int size;

    public Find_Median_from_Data_Stream() {
        mem = new ArrayList<>();
        size = 0;
    }

    public void addNum(int num) {

        if (mem.size() == 0) {
            mem.add(num);
        } else {
            int index = 0;
            while (index < size) {
                if (mem.get(index) < num) {
                    index++;
                } else {
                    mem.add(index, num);
                    size++;
                    return;
                }
            }
            mem.add(num);
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            BigDecimal one = new BigDecimal(mem.get(size / 2));
            BigDecimal two = new BigDecimal(mem.get((size / 2) - 1));
            one = one.add(two);
            one = one.divide(new BigDecimal(2), 5, RoundingMode.CEILING);
            return one.doubleValue();
        } else {
            return mem.get(size / 2);
        }
    }

    public static void main(String[] args) {
        Find_Median_from_Data_Stream it = new Find_Median_from_Data_Stream();
        // ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        // [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
        it.addNum(6);
        System.out.println(it.findMedian());
        it.addNum(10);
        System.out.println(it.findMedian());
        it.addNum(2);
        System.out.println(it.findMedian());
        it.addNum(6);
        System.out.println(it.findMedian());


    }
}
