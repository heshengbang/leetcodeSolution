package com.hsb.leetcode.medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 */
public class Jump_Game {

    public boolean canJump1(int[] nums) {
        int numsLength = nums.length;
        int index = 0;
        int currJump = nums[0];

        while(++index < numsLength && currJump-- != 0){
            currJump = Math.max(currJump, nums[index]);
        }

        System.gc();

        return index >= numsLength;
    }


    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        return jumpWithStep(0, nums);
    }

    private boolean jumpWithStep(int index, int[] nums) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (i >= nums.length - 1) {
                return true;
            } else {
                if (i + nums[i] >= nums.length - 1) {
                    return true;
                } else {
                    if (index + nums[index] < i + nums[i]) {
                        return jumpWithStep(i, nums);
                    }
                }
            }
        }
        return false;
    }



    public boolean canJump2(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int index = 0;
        int maxJump = nums[index];
        for (int i = index + 1; i <= maxJump; i++) {
            if (i >= nums.length - 1 || maxJump >= nums.length - 1) {
                System.gc();
                return true;
            }
            if (i + nums[i] > maxJump) {
                maxJump = nums[i] + i;
            }
        }
        System.gc();
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,1,0,4};
//        Jump_Game item = new Jump_Game();
//        System.out.println(item.canJump2(nums));


//        int[] nums = {2,3,1,1,4};
//        Jump_Game item = new Jump_Game();
//        System.out.println(item.canJump2(nums));


        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        Jump_Game item = new Jump_Game();
        System.out.println(item.canJump2(nums));
    }
}
