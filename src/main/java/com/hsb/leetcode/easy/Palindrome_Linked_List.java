package com.hsb.leetcode.easy;

import com.hsb.leetcode.entity.ListNode;

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
