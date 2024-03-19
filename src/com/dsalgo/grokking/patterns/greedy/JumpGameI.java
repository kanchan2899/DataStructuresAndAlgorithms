package com.dsalgo.grokking.patterns.greedy;


// https://leetcode.com/problems/jump-game/
public class JumpGameI {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 0, 1, 4};
        System.out.println(jumpGame(nums));
    }

    private static boolean jumpGame(int[] nums) {
        int targetIndex = nums.length - 1;

        // traversing the array from back to the first element in the array
        for(int i = nums.length - 2; i >= 0; i--) {
            if(targetIndex <= (i + nums[i])) {
                targetIndex = i;
            }
        }

        if(targetIndex == 0) {
            return true;
        }
        return false;
    }
}
