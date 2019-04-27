package com.hsb.leetcode.easy;

/**
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2019/4/25 9:36
 *
 * @author heshengbang
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class Min_Stack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

class MinStack {
    private int[] elements;
    private int capacity;
    private int lowest;
    private static final int INIT_CAPACITY = 16;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        elements = new int[INIT_CAPACITY];
        capacity = 0;
        lowest = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (elements.length == capacity) {
            int[] newElements = new int[capacity * 2];
            System.arraycopy(elements, 0, newElements, 0, capacity);
            elements = newElements;
        }
        elements[capacity] = x;
        capacity++;
        if (lowest > x) {
            lowest = x;
        }
    }

    public void pop() {
        int removedElement = top();
        int[] newElements = new int[elements.length];
        System.arraycopy(elements, 0, newElements, 0, capacity - 1);
        elements = newElements;
        capacity--;
        if (removedElement == lowest) {
            lowest = Integer.MAX_VALUE;
            for (int i = 0 ; i < capacity; i++) {
                if (lowest > elements[i]) {
                    lowest = elements[i];
                }
            }
        }
    }

    public int top() {
        if (elements == null || elements.length == 0) {
            return 0;
        }
        return elements[capacity - 1];
    }

    public int getMin() {
        if (elements == null || elements.length == 0) {
            return 0;
        }
        if (lowest == Integer.MAX_VALUE) {
            for (int i = 0 ; i < capacity; i++) {
                if (lowest > elements[i]) {
                    lowest = elements[i];
                }
            }
            return lowest;
        }
        return lowest;
    }
}