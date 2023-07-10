package com.hsb.leetcode.medium;

/**
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in ascending order, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 * You must write an algorithm that runs in logarithmic time.
 *
 * https://leetcode.com/problems/h-index-ii/description/
 *
 */
public class H_Index_II {

    public int hIndex2(int[] citations) {
        int length = citations.length;
        int hIndex = 0;
        for (int i = 1; i <= length; i++) {
            if (i <= citations[i - 1] && i <= length - (i - 1)) {
                hIndex = Math.max(hIndex, i);
            }
        }
        return hIndex;
    }

    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] counts = new int[length + 1];
        for (int num: citations) {
            if (num >= length) {
                counts[length]++;
            } else {
                counts[num]++;
            }
        }
        int count = 0;
        for (int h = length; h >= 0; h--) {
            count += counts[h];
            if (count >= h) {
                return h;
            }
        }
        return 0;
    }

    public int hIndex3(int[] citations) {
        int l = -1;
        int r = citations.length;
        while (l + 1 != r){
            int mid = l + (r - l) / 2;
            if (right(citations, mid)){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        return citations.length - r;
    }

    public Boolean right(int[] citations, int mid){
        return citations[mid] >= citations.length - mid;
    }

    public static void main(String[] args) {
        H_Index_II item = new H_Index_II();
        int[] nums = {0,1,3,5,6};
        System.out.println(item.hIndex3(nums));


//        H_Index_II item = new H_Index_II();
//        int[] nums = {1,2,100};
//        System.out.println(item.hIndex(nums));

//        H_Index_II item = new H_Index_II();
//        int[] nums = {100};
//        System.out.println(item.hIndex(nums));

//        H_Index_II item = new H_Index_II();
//        int[] nums = {11,15};
//        System.out.println(item.hIndex(nums));
    }
}
