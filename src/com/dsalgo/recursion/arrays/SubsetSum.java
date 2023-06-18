package com.dsalgo.recursion.arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {10, 12, 8, 26, 6};
        int sum = 18;

        System.out.println(countSubsetsWithSum(arr, sum));
    }

    private static int countSubsetsWithSum(int[] arr, int sum) {
        return helper(arr, sum, 0);
    }

    private static int helper(int[] arr, int sum, int index) {
        if(index >= arr.length) {
            return sum == 0 ? 1 : 0;
        }
        return helper(arr, sum, index + 1) + helper(arr, sum - arr[index], index + 1);
    }
}
