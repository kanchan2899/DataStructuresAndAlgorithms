package com.dsalgo.recursion.arrays;

// https://leetcode.com/problems/predict-the-winner/description/
public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 5};
        System.out.println("Does P1 win? " + predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {
        int p1Score = helper(nums, 0, nums.length - 1);
        int total = getTotal(nums);

        return p1Score >= (total - p1Score);
    }

    private static int helper(int[] nums, int i, int j) {
        if(i > j){
            return 0;
        }
        if(i == j) {
            return nums[j];
        }

        int currentScore = Math.max(
                nums[i] + Math.min(
                        helper(nums, i + 2, j),
                        helper(nums, i + 1, j - 1)
                ),
                nums[j] + Math.min(
                        helper(nums, i, j - 2),
                        helper(nums, i + 1, j - 1
                        )
                )
        );
        return currentScore;
    }

    static int getTotal(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        return total;
    }
}
