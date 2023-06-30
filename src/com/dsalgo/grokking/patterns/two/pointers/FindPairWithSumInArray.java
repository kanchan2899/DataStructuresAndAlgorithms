package com.dsalgo.grokking.patterns.two.pointers;

// https://practice.geeksforgeeks.org/problems/pair-sum-existence/1
public class FindPairWithSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 20;
        System.out.println("Using 2 nested loops: " + sumExists(arr, arr.length, sum));
        System.out.println("Using two pointers approach: " + sumExists1(arr, arr.length, sum));
    }

    /**
     *
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    private static boolean sumExists1(int[] arr, int n, int sum) {
        int i = 0, j = n - 1;
        while (i < j) {
            if(arr[i] + arr[j] == sum) {
                return true;
            } else if(arr[i] + arr[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * Using 2 nested loops:
     *
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    public static boolean sumExists(int arr[], int n, int sum) {
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}
