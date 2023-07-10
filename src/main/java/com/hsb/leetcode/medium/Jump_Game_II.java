package com.hsb.leetcode.medium;

/**
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class Jump_Game_II {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int index = 0, maxJump = index + nums[index], step = 0, length = nums.length;
        while (maxJump < length - 1) {
            int count = index + 1;
            int nextJump = 0, nextIndex = count;
            while (count <= maxJump) {
                if (count + nums[count] > nextJump) {
                    nextJump = count + nums[count];
                    nextIndex = count;
                }
                count++;
            }
            maxJump = nextJump;
            index = nextIndex;
            step++;
        }
        System.gc();
        return step + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        Jump_Game_II item = new Jump_Game_II();
//        System.out.println(item.jump(nums));

//        int[] nums = {2,3,0,1,4};
//        Jump_Game_II item = new Jump_Game_II();
//        System.out.println(item.jump(nums));

//        int[] nums = {0};
//        Jump_Game_II item = new Jump_Game_II();
//        System.out.println(item.jump(nums));

        int[] nums = {1, 1};
        Jump_Game_II item = new Jump_Game_II();
        System.out.println(item.jump(nums));
    }
}
