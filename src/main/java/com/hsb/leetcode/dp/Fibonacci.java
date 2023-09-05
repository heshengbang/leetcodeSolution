package com.hsb.leetcode.dp;

public class Fibonacci {
    private int fibonacciWithMemory(int n, int[] memory) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        if (n > 1) {
            memory[n] = fibonacciWithMemory(n - 1, memory) + fibonacciWithMemory(n - 2, memory);
            return memory[n];
        }
        return -1;
    }


    private int fibonacci(int n) {
        int[] resolution = {0, 1};
        if (n < 2) {
            return resolution[n];
        }
        int i = 1;
        int fib1 = 0, fib2 = 1, fib = 0;
        while (i < n) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            i++;
        }
        return fib;
    }

    public static void main(String[] args) {
        Fibonacci it = new Fibonacci();
        long s1 = System.currentTimeMillis();
        System.out.println(it.fibonacci(10000));
        System.out.println("no memory: " + (System.currentTimeMillis() - s1));

        int[] memory = new int[10001];
        long s2 = System.currentTimeMillis();
        System.out.println(it.fibonacciWithMemory(10000, memory));
        System.out.println("With memory: " + (System.currentTimeMillis() - s2));
    }
}
