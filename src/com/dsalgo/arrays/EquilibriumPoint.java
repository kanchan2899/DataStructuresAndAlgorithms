package com.dsalgo.arrays;

// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/?ref=gcse
public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumPoint(arr, arr.length));
        System.out.println(equilibriumPoint1(arr, arr.length));
    }


    /**
     * Bruteforce approach: Iterate for each index i and calculate the leftsum and rightsum
     * and check whether they are equal.
     *
     *
     * TC: O(n^2)
     * SC: O(1)
     */
    private static int equilibriumPoint1(long[] arr, int length) {
        for(int i = 0; i < length; i++) {
            int left_sum = 0;
            for(int j = 0; j < i; j++) {
                left_sum += arr[j];
            }
            int right_sum = 0;
            for(int j = i + 1; j < arr.length; j++) {
                right_sum += arr[j];
            }

            if(left_sum == right_sum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Bruteforce: Calculate the total sum first. Iterate for each index j from 1
     *  to n-1 and calculate the left_sum by just adding arr[i-1] and right_sum
     *  and check by subtracting current element and left_sum from totalSum.
     *  If left_sum == right_sum, return the index.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param n
     * @return
     */
    public static int equilibriumPoint(long arr[], int n) {
        int equilibriumPoint = -1;
        if(n <= 1) {
            equilibriumPoint = n;
        }
        long sumLeft = 0;
        long sumRight = 0;
        long totalSum = 0;


        for(int j = 0; j < arr.length; j++) {
            totalSum += arr[j];
        }

        for(int i = 1; i < arr.length; i++) {
            sumLeft += arr[i - 1];
            sumRight = totalSum - arr[i] - sumLeft;
            if(sumRight == sumLeft) {
                equilibriumPoint = i;
            }
        }
        return equilibriumPoint;
    }

}
