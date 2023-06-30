package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1
public class MinimumConsecutiveFlips {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(minimumConsecutiveFlips(arr));
        minimumConsecutiveFlips1(arr);
    }

    /**
     * Bruteforce: Traverse do two traversals of the array.
     * We first traverse to find the number of groups of 0s and the number of groups of 1.
     * We find the minimum of these two.
     * Then we traverse the array and flip the 1s if groups of 1s are less. Otherwise, we flip 0s.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int minimumConsecutiveFlips(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min_value = -1;
        int i = 0;
        while(i < arr.length) {
            if(arr[i] == 0) {
                while (i < arr.length && arr[i] == 0) {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                    i++;
                }
            } else {
                while (i < arr.length && arr[i] == 1) {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                    i++;
                }
            }
        }

        return min_value;
    }

    /**
     * An Efficient Solution is based on the below facts :
     *
     * 1. There are only two types of groups (groups of 0s and groups of 1s)
     * 2. Either the counts of both groups are same or the difference between counts is at most 1.
     * For example, in {1, 1, 0, 1, 0, 0} there are two groups of 0s and two groups of 1s.
     * In example, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1}, count of groups of 1 is one more than the counts of 0s.
     * Based on the above facts, we can conclude that if we always flip the second group
     * and other groups that of the same type as the second group, we always get the correct answer.
     * In the first case, when group counts are the same, i
     * t does not matter which group type we flip as both will lead to the correct answer.
     * In the second case, when there is one extra,
     * by ignoring the first group and starting from the second group,
     * we convert this case to first case (for subarray beginning from the second group)
     * and get the correct answer.
     *
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     */
    private static void minimumConsecutiveFlips1(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                if(arr[i] != arr[0]) {
                    System.out.print("From " + i + " to ");
                } else {
                    System.out.println(i - 1);
                }
            }
        }
        if(arr[arr.length - 1] != arr[0]) {
            System.out.println(arr.length - 1);
        }
    }
}
