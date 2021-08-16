package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.ListNode;

/**
 * 类描述:
 * Copyright 多点生活（成都）科技有限公司
 *
 * @author hu.he@dmall.com 何虎
 * @version 1.0
 * @since 2021/8/4 9:53
 */

public class Palindrome_Linked_List {
    public static boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        if (count <= 1) {
            return true;
        }
        int[] arr = new int[count];
        int index = 0;
        current = head;
        while (current != null) {
            arr[index] = current.val;
            index++;
            current = current.next;
        }
        int i = 0, j = count - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
