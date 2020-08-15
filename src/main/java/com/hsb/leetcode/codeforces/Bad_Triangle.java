package com.hsb.leetcode.codeforces;

/*
 * 类描述:
 *************************************************
 */

import java.util.*;

public class Bad_Triangle {

    private static long[] a = new long[100005];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            boolean flag = false;
            for(int i = 2;i<n;i++){
                if(a[i] >= a[0] + a[1]){
                    System.out.println("1 2 "+(i+1));
                    flag= true;
                    break;
                }
            }
            if(!flag){
                System.out.println("-1");
            }

        }

    }
}
