package com.hsb.leetcode.medium;

import java.util.*;

public class Find_K_Pairs_with_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int nl1 = nums1.length, nl2 = nums2.length;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)));
        for (int i = 0; i < nl1; i++) {
            for (int j = 0; j < nl2; j++) {
                if (queue.size() < k) {
                    queue.add(Arrays.asList(nums1[i], nums2[j]));
                } else {
                    int num = nums1[i] + nums2[j];
                    List<Integer> tmp = queue.peek();
                    if (num < tmp.get(0) + tmp.get(1)) {
                        queue.poll();
                        queue.add(Arrays.asList(nums1[i], nums2[j]));
                    } else {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> num: queue) {
            result.add(num);
        }
        return result;
    }


    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int nl1 = nums1.length, nl2 = nums2.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> (o2.n1 + o2.n2) - (o1.n1 + o1.n2));
        for (int i = 0; i < nl1; i++) {
            for (int j = 0; j < nl2; j++) {
                // 构造一个容量大小为k的大顶堆，超过容量就把堆顶最大的元素出队
                if (queue.size() < k) {
                    queue.add(new Pair(nums1[i], nums2[j]));
                } else {
                    Pair pair = queue.peek();
                    if (pair.n1 + pair.n2 > nums1[i] + nums2[j]) {
                        queue.poll();
                        queue.add(new Pair(nums1[i], nums2[j]));
                    } else {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Pair pair: queue) {
            result.add(pair.toList());
        }
        return result;
    }
    private class Pair {
        int n1;
        int n2;
        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public List<Integer> toList() {
            return Arrays.asList(n1, n2);
        }
    }



    public static void main(String[] args) {
        int[] num1 = {1, 1, 2}, num2 = {1, 2, 3};
        int k = 2;
        Find_K_Pairs_with_Smallest_Sums it = new Find_K_Pairs_with_Smallest_Sums();
        System.out.println(it.kSmallestPairs(num1, num2, k));
    }
}
