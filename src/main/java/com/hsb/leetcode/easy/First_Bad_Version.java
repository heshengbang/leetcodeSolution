package com.hsb.leetcode.easy;

/*
 * 类描述:
 * @since 2019/12/10 21:14
 * @version 1.0
 */

public class First_Bad_Version extends VersionControl {
    public static int badVersion = 0;
    public int firstBadVersion(int n) {
        if (n == 1) {
            return n;
        }
        long left = 0, right = n, temp, current = n;
        while (true) {
            if (current <= Integer.MAX_VALUE) {
                if (isBadVersion(new Long(current).intValue()) && !isBadVersion(new Long(current - 1).intValue())) {
                    return new Long(current).intValue();
                }
            }
            temp = current;
            current = (left + right) / 2;
            if (isBadVersion(new Long(temp).intValue())) {
                right = temp;
            } else {
                left = temp;
            }
        }
    }

    public int firstBadVersion1(int n) {
        int left = 1, right = n, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        First_Bad_Version.badVersion = 2;
        First_Bad_Version item = new First_Bad_Version();
        System.out.println(item.firstBadVersion(2));
    }

}
class VersionControl {
    public boolean isBadVersion(int n) {
        return n >= First_Bad_Version.badVersion;
    }
}